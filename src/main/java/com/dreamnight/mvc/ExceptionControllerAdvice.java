package com.dreamnight.mvc;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionControllerAdvice{

    private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	
	/** 
     * 异常页面控制 
     * @param runtimeException
     * @return 
     */  
	@ExceptionHandler(Throwable.class)  
    public @ResponseBody  Map<String,Object> runtimeExceptionHandler(RuntimeException runtimeException) {  
        logger.error("ExceptionControllerAdvice get error!", runtimeException);
        Map<String, Object> model = new TreeMap<String, Object>();  
        model.put("status", "ExceptionControllerAdvice");  
        return model;  
    }

}
