package com.datayes.paas.authorization.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datayes.paas.authorization.dao.api.AuthorizationDao;
import com.datayes.paas.authorization.entity.Application;
import com.datayes.paas.authorization.entity.ApplicationInstance;
import com.datayes.paas.authorization.exception.PermissionException;
import com.datayes.paas.authorization.model.Message;
import com.datayes.paas.authorization.model.UserPermission;
import com.datayes.paas.authorization.model.db.PermissionTree;
import com.datayes.paas.authorization.service.api.AuthorizationService;
@Service
public class AuthorizationServiceImpl implements AuthorizationService{
	private Logger log = LoggerFactory.getLogger(AuthorizationServiceImpl.class);
	@Autowired
	AuthorizationDao dao;
	public Message addApplication(Application application) {
		dao.addApplication(application);
		return null;
	}

	public Message upgradeApplication(Application application) {
		dao.upgradeApplication(application);
		return null;
	}


	public void addInstance(ApplicationInstance instance) throws PermissionException {
		try{
			dao.addInstance(instance);
		}catch(RuntimeException e){
			throw new PermissionException(500, "Error: add instance failed.");
		}
	}
	public Message assignInstancesToTenant(String tenantDomain, List<Long> instances) {
		dao.batchUpdateInstanceTenant(tenantDomain, instances);
		return null;
	}
	public List<PermissionTree> listAllInstances(String tenantDomain) {
		return dao.listAllInstances(tenantDomain);
	}

	
	public Message updateInstance(String enName, String chName) {
		// TODO Auto-generated method stub
		return null;
	}


	public Message getInstancesOfTenant(String tenantDomain) {
		// TODO Auto-generated method stub
		return null;
	}

	public Message deleteInstancesFromTenant(String tenantDomain, String enName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Message authorize(UserPermission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> lisAllApplications() {
		List<String> list =  dao.listAll();
		for(String string : list){
			log.info(string);
		}
		return list;
	}

}
