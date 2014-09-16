package com.datayes.paas.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.datayes.paas.authorization.model.SingleObjectModel;

/**
 * Copyright © 2014 Datayes. All rights reserved.
 * @author: qianzhong.fu  
 * @date: 2014年9月16日 下午2:40:41 
 */
@Controller
public class BaseController {
	protected ModelMap getResultMap(Object o) {
        if (o == null) return null;
        if (o instanceof Boolean || o instanceof Integer || o instanceof Long || o instanceof Double || o instanceof Byte) {
            return new ModelMap(new SingleObjectModel(o));
        } else return new ModelMap(o);
    }
}
