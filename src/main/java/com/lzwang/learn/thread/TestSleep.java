package com.lzwang.learn.thread;

/**
 * Created by lzwang on 2018/7/31.
 */
public class TestSleep {

    private int i=10;
    private Object ob = new Object();

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        MyThread2 t1 = testSleep.new MyThread2();
        MyThread2 t2 = testSleep.new MyThread2();
        t1.run();
        t2.run();

    }

    class MyThread2 extends Thread {
        @Override
        public void run() {
            synchronized (ob) {
                i++;
                System.out.println("当前i值为：" + i);
                System.out.println("当前线程" + Thread.currentThread().getName() + "处于休眠状态");
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程" + Thread.currentThread().getName() + "休眠结束");
                i++;
                System.out.println("当前i值>:" + i);
            }
        }
    }
}
