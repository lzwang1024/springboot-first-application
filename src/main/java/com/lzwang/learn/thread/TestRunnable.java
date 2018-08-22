package com.lzwang.learn.thread;

/**
 * Created by lzwang on 2018/7/31.
 */
public class TestRunnable {

    public static void main(String[] args) {
        System.out.println("主线程线程id为：" + Thread.currentThread().getId());
        TestRunnable tr = new TestRunnable();
        MyThread myThread = tr.new MyThread("lzwang");
        Thread t = new Thread(myThread);
//        t.start();
        t.start();
    }

    class MyThread implements Runnable {

        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("当前运行线程"+name+",id为：" + Thread.currentThread().getId());
        }
    }
}
