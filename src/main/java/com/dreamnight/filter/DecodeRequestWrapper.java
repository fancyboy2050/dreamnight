package com.dreamnight.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.util.StringUtils;

public class DecodeRequestWrapper extends HttpServletRequestWrapper{
	
	Map<String, Object> parameterMap = new HashMap<String, Object>();

	public DecodeRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	public void putAll(Map<String, Object> map) {
	    this.parameterMap.putAll(map);
	}
	
	public void putOne(String key, String value) {
	    this.parameterMap.put(key, value);
	}

	@Override
	public String getParameter(String name) {
		String value = this.getRequest().getParameter(name);
		if(StringUtils.isEmpty(value)){
			value = String.valueOf(this.parameterMap.get(name));
		}
	    return value;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		String[] values = this.getRequest().getParameterValues(name);
		if(values != null && values.length > 0){
			return values;
		} else {
			Object obj = this.parameterMap.get(name);
			if(obj != null){
				String value = String.valueOf(this.parameterMap.get(name));
				return new String[]{value};
			} else {
				return new String[]{};
			}
		}
	}

}
