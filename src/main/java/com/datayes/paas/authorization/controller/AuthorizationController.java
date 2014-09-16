package com.datayes.paas.authorization.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datayes.paas.authorization.constant.Constant;
import com.datayes.paas.authorization.entity.*;
import com.datayes.paas.authorization.exception.PermissionException;
import com.datayes.paas.authorization.model.Message;
import com.datayes.paas.authorization.model.db.PermissionTree;
import com.datayes.paas.authorization.service.api.AuthorizationService;
import com.datayes.paas.authorization.util.CommonUtil;

import javax.servlet.http.HttpServletResponse;  
/**
 * Copyright © 2014 Datayes. All rights reserved.
 * @author: qianzhong.fu  
 * @date: 2014年9月7日 上午9:47:38 
 */
@Controller
public class AuthorizationController extends BaseController{
	@Autowired
	AuthorizationService authorizationService;
	
	@RequestMapping(value = "/addApplication",method = RequestMethod.POST
			,produces = Constant.JSON_TYPE)
	public @ResponseBody Message addApplication
	(@RequestBody Application application){
		return authorizationService.addApplication(application);
	}
	
	@RequestMapping(value = "/upgradeApplication",method = RequestMethod.POST
			,produces = Constant.JSON_TYPE)
	public @ResponseBody Message upgradeApplication
	(@RequestBody Application application){
		return authorizationService.upgradeApplication(application);
	}
	
	@RequestMapping(value = "/addInstance",method = RequestMethod.POST
			,produces = Constant.JSON_TYPE)
	public ModelMap addInstance(@RequestBody ApplicationInstance instance){//ModelMap 不能使用@ResponseBody修饰，否则@ResponseBody会将ModelMap当做是java bean
		try {
			authorizationService.addInstance(instance);
		} catch (PermissionException e) {
			return getResultMap(new Message(500,e.getMessage()));
		}
		return getResultMap(new Message(200,"success"));
	}
	
	@RequestMapping(value = "/assignInstancesToTenant/{tenantDomain}",
			method = RequestMethod.POST,produces = Constant.JSON_TYPE)
	public @ResponseBody Message assignInstancesToTenant
	(@PathVariable String tenantDomain,@RequestBody List<Long> instances){
		return authorizationService.assignInstancesToTenant(tenantDomain, instances);
	}
	
	@RequestMapping(value = "/allInstances/{tenantDomain}",method = RequestMethod.GET
			,produces = Constant.JSON_TYPE)
	public @ResponseBody List<PermissionTree> listAllInstances(
			@PathVariable String tenantDomain){
        return authorizationService.listAllInstances(tenantDomain);
	}
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Exception.class)
    @ResponseBody
    public Map handleException(HttpServletResponse response, Exception e) {
        return CommonUtil.handleException(response, e);
    }
}
