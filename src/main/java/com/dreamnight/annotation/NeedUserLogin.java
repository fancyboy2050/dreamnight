package com.dreamnight.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedUserLogin {

	/**
	 * 用户登录必要
	 * @return
	 */
	boolean userLogin() default true;

}
