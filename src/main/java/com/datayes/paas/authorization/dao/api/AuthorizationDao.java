package com.datayes.paas.authorization.dao.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.datayes.paas.authorization.entity.Application;
import com.datayes.paas.authorization.entity.ApplicationInstance;
import com.datayes.paas.authorization.model.db.PermissionTree;
import com.datayes.paas.authorization.model.db.TreeNode;

/**
 * Copyright © 2014 Datayes. All rights reserved.
 * @author: qianzhong.fu  
 * @date: 2014年9月7日 上午11:23:06 
 */
@Repository
@Transactional
public class AuthorizationDao{
	public static final int FLUSH_SIZE = 20; 
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public <T> List<T> listAll(final Class<T> type){
	    final Criteria crit = getSession().createCriteria(type);
	    crit.setProjection(Projections.property("en_name"));
	    return crit.list();
	}
	public List<String> listAll(){
		String hql = "select enName from Application";
		Query query = getQuery(hql);
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}
	public void addApplication(Application app){
		Session session = getSession();
		session.save(app);
	}
	public void upgradeApplication(Application app){
		Session session = getSession();
		session.update(app);
	}
	public void addInstance(ApplicationInstance instance){
		Session session = getSession();
		session.save(instance);
	}
	public void updateInstanceTenant(String tenantDomain,long instanceId){
		Session session = getSession();
		String hql = "update ApplicationInstance ai set ai.tenantDomain = :tenantDomain "
				+ "where ai.id = :instanceId";
		Query query = session.createQuery(hql).setParameter("tenantDomain", tenantDomain)
							.setParameter("instanceId", instanceId);
		query.executeUpdate();
	}
	@CacheEvict(value="permissionCache",key="'listAllInstances|'+#tenantDomain")
	public void batchUpdateInstanceTenant(String tenantDomain, List<Long> instances) {
		Session session = getSession();
		int count = 0;
		for(Long instance : instances){
			long instanceId = instance.longValue();
			updateInstanceTenant(tenantDomain,instanceId);
			if(++count % FLUSH_SIZE == 0){
				session.flush();
				session.clear();
			}
		}
	}
	private Query getQuery(String hql){
		return getSession().createQuery(hql);
	}
	@Cacheable(value="permissionCache" , key="'listAllInstances|'+#tenantDomain")
	@SuppressWarnings("unchecked")
	public List<PermissionTree> listAllInstances(String tenantDomain){
		Session session = getSession();
		String sql = "select a.instance_id,a.name as a_name,f.feature_id,f.name"
				+ " as f_name from app_instance as a inner join feature as f "
				+ "where a.app_id = f.app_id and a.tenant_domain = :tenantDomain "
				+ "order by a.instance_id";
		Query query = session.createSQLQuery(sql)
				.setParameter("tenantDomain", tenantDomain);
		List<Object[]> list = query.list();
		List<PermissionTree> tree = new ArrayList<PermissionTree>();
		int count = 0;
		while(count<list.size()){
			PermissionTree pTree = new PermissionTree();
			Object row[] = list.get(count);
			long id = ((BigInteger)row[0]).longValue();
			pTree.setId(id);
			pTree.setName((String)row[1]);
			List<TreeNode> subTree = new ArrayList<TreeNode>();
			while(count<list.size() && ((BigInteger)((row = list.get(count++))[0])).longValue() == id)
				subTree.add(new TreeNode(((BigInteger)row[2]).longValue(),(String)row[3]));
			pTree.setFeatures(subTree);
			tree.add(pTree);
		}
		return tree;
	}
}
