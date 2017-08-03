package com.dreamnight.remote.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;

public class RemoteInteceptor implements MethodInterceptor, Ordered {
	
	private static final Logger logger = LoggerFactory.getLogger(RemoteInteceptor.class);

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Method method = invocation.getMethod();
		logger.info(method.getName());
		Object[] arguments = invocation.getArguments();
		for(Object o : arguments){
			logger.info("arguments : "+o.toString());
		}
		Object returnValue = invocation.proceed();
		logger.info("returnValue : "+returnValue);
		return returnValue;
	}

}
