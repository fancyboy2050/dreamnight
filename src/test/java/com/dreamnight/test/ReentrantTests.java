package com.dreamnight.test;

/**
 * Created by tianbenzhen on 2017/10/11.
 */
public class ReentrantTests {

    public static void main(String[] args) {
        final ReentrantTests rt = new ReentrantTests();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                rt.do1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                rt.do2();
            }
        });
        System.out.println("---------------t1.start()!");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------t2.start()!");
        t2.start();
    }

    public synchronized void do1(){
        System.out.println("--------------------do 1!");
        do2();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------do 1 end!");
    }

    public synchronized  void do2(){
        System.out.println("--------------------do 2!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------do 2 end!");
    }

}
