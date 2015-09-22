package com.dreamnight.test;

import com.dreamnight.threadlocal.ThreadLocalDateFormat;

public class TestThreadLocalDateFormat {
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<3; i++){
					System.out.println(Thread.currentThread().getName()+"   |   "+ThreadLocalDateFormat.instance("yyyy-MM-dd").get());
				}
			}
		});
			
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<3; i++){
					System.out.println(Thread.currentThread().getName()+"   |   "+ThreadLocalDateFormat.instance("yyyy-MM-dd").get());
				}
			}
		});
			
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<3; i++){
					System.out.println(Thread.currentThread().getName()+"   |   "+ThreadLocalDateFormat.instance("yyyy-MM-dd HH:mm:ss").get());
					System.out.println(Thread.currentThread().getName()+"   |   "+ThreadLocalDateFormat.instance("yyyy-MM-dd").get());
				}
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}

}
