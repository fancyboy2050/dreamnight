package com.dreamnight.threadlocal;

import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalDateFormat extends ThreadLocal<SimpleDateFormat>{
	
	private static final ConcurrentHashMap<String, ThreadLocalDateFormat> CONCURRENT_HASH_MAP = new ConcurrentHashMap<String, ThreadLocalDateFormat>();
	private String pattern;
	
	private ThreadLocalDateFormat(String pattern) {
		this.pattern = pattern;
	}
	
	public static synchronized ThreadLocalDateFormat instance(String pattern){
		ThreadLocalDateFormat threadLocalDateFormat = CONCURRENT_HASH_MAP.get(pattern);
		if(threadLocalDateFormat == null){
			threadLocalDateFormat = new ThreadLocalDateFormat(pattern);
			CONCURRENT_HASH_MAP.put(pattern, threadLocalDateFormat);
		}
		return threadLocalDateFormat;
	}

	@Override
	protected SimpleDateFormat initialValue() {
		return new SimpleDateFormat(pattern);
	}

}
