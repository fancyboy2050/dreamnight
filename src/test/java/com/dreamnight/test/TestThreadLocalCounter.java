package com.dreamnight.test;

import com.dreamnight.threadlocal.ThreadLocalCounter;

public class TestThreadLocalCounter {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<3; i++){
//					ThreadLocalCounter.instance().set(ThreadLocalCounter.instance().get()+1);
					System.out.println(Thread.currentThread().getName()+ "   |   " + ThreadLocalCounter.instance().increAndGet(2));
					add();
				}
			}
		});
			
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<3; i++){
//					ThreadLocalCounter.instance().set(ThreadLocalCounter.instance().get()+1);
					System.out.println(Thread.currentThread().getName()+"   |   "+ThreadLocalCounter.instance().increAndGet(2));
					add();
				}
			}
		});
			
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<3; i++){
//					ThreadLocalCounter.instance().set(ThreadLocalCounter.instance().get()+1);
					System.out.println(Thread.currentThread().getName()+"   |   "+ThreadLocalCounter.instance().increAndGet(2));
					add();
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void add(){
		System.out.println(Thread.currentThread().getName()+ "   |   " + ThreadLocalCounter.instance().increAndGet(1));
	}

}
