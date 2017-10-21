package com.csf.datamonitor.common;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.csf.datamonitor.common.base.RespObj;
import com.csf.datamonitor.common.base.RespType;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gson.Gson;

public class BaseServiceImpl {
	protected Logger log = Logger.getLogger(getClass());

	private static final Gson gson= new Gson();
	
	
	protected String dto2json(RespObj returnDTO){
		return gson.toJson(returnDTO);
	}

	protected String returnParamErrAsJson(String type){
		RespObj res = new RespObj();
		res.setCode(RespType.PARAMETEREXCEPTION.getCode());
		res.setType(type);
		res.setMessage(null);
		return dto2json(res);
	}
	
	protected String returnParamErrAsJson(String type, String message){
		RespObj res = new RespObj();
		res.setCode(RespType.PARAMETEREXCEPTION.getCode());
		res.setType(type);
		res.setMessage(message);
		return dto2json(res);
	}
	
	protected String returnSuccAsJson(Object message){
		RespObj res = new RespObj();
		res.setCode(RespType.SUCCESS.getCode());
		res.setType(RespType.SUCCESS.name());
		res.setMessage(message);
		return dto2json(res);
	}
	
	protected String returnExceptionAsJson(Exception e){
		RespObj res = new RespObj();
		res.setCode(RespType.RUNTIME_EXCEPTION.getCode());
		res.setType(e.getClass().getName());
		StringBuilder sb = new StringBuilder();
		for(StackTraceElement stack : e.getStackTrace()){
			sb.append(stack);
		}
		res.setMessage(sb);
		return dto2json(res);
	}
	
	protected String returnNullAsJson(Exception e){
		RespObj res = new RespObj();
		res.setCode(RespType.RUNTIME_EXCEPTION.getCode());
		res.setType(e.getClass().getName());
		res.setMessage(null);
		return dto2json(res);
	}
	
	protected String returnAsJson(String code, String type, Object message){
		RespObj res = new RespObj();
		res.setCode(code);
		res.setType(type);
		res.setMessage(message);
		return dto2json(res);
	}
	
	protected String[] formatKey(String keys){
		if(StringUtils.isBlank(keys)){
			return new String[]{};
		}
		return keys.split(",");
	}
	
	protected List<String> formatListParam(String param){
		List<String> result = Lists.newArrayList();
		if(StringUtils.isBlank(param)){
			return result;
		}
		String[] split = param.split(",");
		result.addAll(Arrays.asList(split));
		return result;
	}
	
	protected List<Long> formatLongListParam(String param){
		List<Long> result = Lists.newArrayList();
		if(StringUtils.isBlank(param)){
			return result;
		}
		String[] split = param.split(",");
		for(String s : split){
			if(StringUtils.isBlank(s)) continue;
			result.add(Long.valueOf(s));
		}
		return result;
	}
	
	
	protected List<ObjectId> formatObjectIdListParam(String param){
		List<ObjectId> result = Lists.newArrayList();
		if(StringUtils.isBlank(param)){
			return result;
		}
		String[] split = param.split(",");
		for(String s : split){
			if(StringUtils.isBlank(s)) continue;
			result.add(new ObjectId(s));
		}
		return result;
	}
	
	protected Set<String> formatSetParam(String param){
		Set<String> result = Sets.newHashSet();
		if(StringUtils.isBlank(param)){
			return result;
		}
		String[] split = param.split(",");
		result.addAll(Arrays.asList(split));
		return result;
	}
	
	public HttpServletRequest getRequest(){
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		return request;
	}
}
