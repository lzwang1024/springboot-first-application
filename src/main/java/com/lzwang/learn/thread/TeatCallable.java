package com.lzwang.learn.thread;

import java.util.concurrent.*;

/**
 * Created by lzwang on 2018/8/1.
 */
public class TeatCallable {
    public static void main(String[] args) {
        TeatCallable teatCallable = new TeatCallable();

        ExecutorService pool = Executors.newFixedThreadPool(3);

        MyCallableTest test1 = teatCallable.new MyCallableTest("name1");
        MyCallableTest test2 = teatCallable.new MyCallableTest("name2");
        MyCallableTest test3 = teatCallable.new MyCallableTest("name3");

        MyRunnableTest test4 = teatCallable.new MyRunnableTest("run4");
        Thread thread = new Thread(test4);
        thread.start();

        Future f1 = pool.submit(test1);
        Future f2 = pool.submit(test2);
        Future f3 = pool.submit(test3);

        try {
            System.out.println(f1.get().toString());
            System.out.println(f2.get().toString());
            System.out.println(f3.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    class MyCallableTest implements Callable {

        String name;

        public MyCallableTest(String name) {
            this.name = name;
        }

        @Override
        public Object call() throws Exception {
            return name+"返回了结果";
        }
    }

    class MyRunnableTest implements Runnable {

        String name;

        public MyRunnableTest(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name+"run...");
        }
    }
}
