package com.datayes.paas.authorization.model;

/**
 * Copyright © 2014 Datayes. All rights reserved.
 * @author: qianzhong.fu  
 * @date: 2014年9月16日 下午2:41:56 
 */
public class SingleObjectModel {
    private Object value;

    public SingleObjectModel(){}

    public SingleObjectModel(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
