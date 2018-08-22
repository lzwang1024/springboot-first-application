package com.lzwang.learn.thread;

/**
 * Created by lzwang on 2018/7/31.
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        new MyThread3("t1").start() ;
        for (int i = 0; i < 10; i++) {
            if(i == 5){
                MyThread3 my =new MyThread3("t2") ;
                my.start() ;
                my.join() ;//等待线程对象销毁，如果子线程执行了这个方法，那么主线程就要等待子线程执行完毕之后才会销毁
            }
            System.out.println("main当前线程："+Thread.currentThread().getName()+" "+i);
        }
    }

    static class MyThread3 extends Thread {
        public MyThread3(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("当前线程："+Thread.currentThread().getName()+" "+i);
            }
        }
    }
}
