package com.datayes.paas.authorization.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

/**
 * Copyright © 2014 Datayes. All rights reserved.
 * @author: qianzhong.fu  
 * @date: 2014年9月16日 下午1:51:43 
 */
public class CommonUtil {
	@SuppressWarnings({"unchecked", "rawtypes"})
    public static Map handleException(HttpServletResponse response,
                                      Exception e, Logger log) {
        response.setStatus(500);
        Map model = new HashMap();
        model.put("error", e.getMessage());
        return model;
    }
	
	@SuppressWarnings({"unchecked", "rawtypes"})
    public static Map handleException(HttpServletResponse response,
                                      Exception e) {
        response.setStatus(500);
        Map model = new HashMap();
        model.put("error", e.getMessage());
        return model;
    }
	
	@SuppressWarnings({"unchecked", "rawtypes"})
    public static Map handleException(HttpServletResponse response,
                                      String errorMessage) {
        response.setStatus(500);
        Map model = new HashMap();
        model.put("error", errorMessage);
        return model;
    }
}
