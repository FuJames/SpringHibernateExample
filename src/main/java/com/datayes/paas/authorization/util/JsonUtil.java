package com.datayes.paas.authorization.util;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
/**
 * Copyright © 2014 Datayes. All rights reserved.
 * @author: qianzhong.fu  
 * @date: 2014年9月11日 上午11:01:35 
 */
public class JsonUtil {
	private static final ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	/*
	 * 
	 * @param Java Array,List or POJO 
	 * @return Json String
	 * @throws IOException
	 */
	public static String objToJson(Object obj) throws IOException{
		return	mapper.writeValueAsString(obj);
	}
	public static <T> T JsonToObject(String json,Class<T> t) throws IOException{
		return	mapper.readValue(json,t);
	}
	public static <T> List<T> JsonToList(String json, Class<T> t) throws IOException {
        return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(List.class, t));
    }
}
