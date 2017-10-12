package com.dreamnight.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tianbenzhen on 2017/9/29.
 */
public class ScheduledTests {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("t1 sleep 2000");
                    throw  new NullPointerException();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 sleep 2000");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3 sleep 2000");
            }
        });
        scheduler.scheduleAtFixedRate(t1, 1000, 1000, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(t2, 1000, 1000, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(t3, 1000, 1000, TimeUnit.MILLISECONDS);
    }

}
