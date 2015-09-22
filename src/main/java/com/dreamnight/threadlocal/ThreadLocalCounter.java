package com.dreamnight.threadlocal;

public class ThreadLocalCounter extends ThreadLocal<Integer>{
	
	private static final ThreadLocalCounter threadLocalCounter = new ThreadLocalCounter();
	
	private ThreadLocalCounter(){
		
	}
	
	public static ThreadLocalCounter instance(){
		return threadLocalCounter;
	}
	
	@Override
	protected Integer initialValue() {
		return 0;
	}
	
	public Integer increAndGet(int i){
		threadLocalCounter.set(threadLocalCounter.get()+i);
		return threadLocalCounter.get();
	}

}
