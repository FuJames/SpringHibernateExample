package com.datayes.paas.authorization.service.api;

import java.util.List;

import com.datayes.paas.authorization.entity.Application;
import com.datayes.paas.authorization.entity.ApplicationInstance;
import com.datayes.paas.authorization.exception.PermissionException;
import com.datayes.paas.authorization.model.Message;
import com.datayes.paas.authorization.model.UserPermission;
import com.datayes.paas.authorization.model.db.PermissionTree;

/**
 * @author qianzhong.fu
 *
 */
public interface AuthorizationService {
	public List<String> lisAllApplications();
	public Message addApplication(Application application);
	public Message upgradeApplication(Application application);
	public void addInstance(ApplicationInstance instance)throws PermissionException;
	public Message updateInstance(String enName, String chName);
	public Message getInstancesOfTenant(String tenantDomain);
	public Message deleteInstancesFromTenant(String tenantDomain,String enName);
	public Message authorize(UserPermission permission);
	public Message assignInstancesToTenant(String tenantDomain, List<Long> instances);
	public List<PermissionTree> listAllInstances(String tenantDomain);
	
}
