package com.lzwang.learn.thread;

import java.util.concurrent.*;

/**
 * Created by lzwang on 2018/8/1.
 */
public class FutureGetTimeOut1 {
    public static void main(String[] args){
        int timeout = 2;
        // 单个线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Boolean result = false;
        Future<Boolean> future = executor.submit(new TaskThread("发送请求"));//将任务提交给线程池
        try {
            result = future.get(timeout, TimeUnit.SECONDS);
//             result = future.get(timeout, TimeUnit.MILLISECONDS); //1
            System.out.println("发送请求任务的返回结果： "+result);  //2
        } catch (InterruptedException e) {
            System.out.println("线程中断出错。");
            future.cancel(true);// 中断执行此任务的线程
        } catch (ExecutionException e) {
            System.out.println("线程服务出错。");
            future.cancel(true);
        } catch (TimeoutException e) {// 超时异常
            System.out.println("超时。");
            future.cancel(true);
        }finally{
            System.out.println("线程服务关闭。");
            executor.shutdown();
        }
    }

    static class TaskThread implements Callable<Boolean> {
        private String t;
        public TaskThread(String temp){
            this.t= temp;
        }
        public Boolean call() {
            //for用于模拟超时
            for(int i=0;i<999999999;i++){
                if(i==999999998){
                    System.out.println(t+"成功！");
                }
                if (Thread.interrupted()){ //很重要
                    return false;
                }
            }
            System.out.println("继续执行..........");
            return true;
        }
    }
}
