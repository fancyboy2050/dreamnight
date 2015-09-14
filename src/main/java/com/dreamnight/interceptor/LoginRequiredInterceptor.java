package com.dreamnight.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dreamnight.annotation.NeedUserLogin;

/**
 * 用户登录必须拦截器
 */
@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

	private final static Logger logger = LoggerFactory.getLogger(LoginRequiredInterceptor.class);
    
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception exception) throws Exception {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
			ModelAndView modelandview) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		NeedUserLogin needUserLogin = null;
		if (obj instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) obj;
			needUserLogin = method.getBean().getClass().getAnnotation(NeedUserLogin.class);
			if (needUserLogin == null) {
				needUserLogin = method.getMethodAnnotation(NeedUserLogin.class);
			}
		} else {
			needUserLogin = obj.getClass().getAnnotation(NeedUserLogin.class);
		}
		if (needUserLogin != null) {
			logger.info("needUserLogin is exists!");
			return true;
		}
		logger.info("needUserLogin not exists!");
		return true;
	}
}
