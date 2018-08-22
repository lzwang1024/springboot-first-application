package com.lzwang.learn;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lzwang on 2018/7/25.
 */
public class VolatileInc implements Runnable {

//    private static volatile int count = 0;
    private static AtomicInteger count = new AtomicInteger();
    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
//            count++;
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        VolatileInc volatileInc = new VolatileInc();
        Thread t1 = new Thread(volatileInc,"t1");
        Thread t2 = new Thread(volatileInc,"t2");

        t1.start();
        t2.start();
        for(int i=0; i<1000;i++) {
//            count++;
            count.incrementAndGet();
        }

        System.out.println("最终count="+count);

    }
}
