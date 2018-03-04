package com.fk.design;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 回掉接口
 *NIO非阻塞类似回掉，读写事件异步轮询
 * @author fk
 * @date 21:01 2018/3/3
 */
public class CallbackDemo {
    //Callback 接口不是程序显示地执行
    public static void main(String[] args) {
        CallbackExecutor executor = new CallbackExecutor();

        executor.execute(()-> System.out.println("hallo"));
        executor.execute(()-> System.out.println("ABC"));

        executor.run();
    }

    public interface Callback{
        void callback();
    }

    public static class CallbackExecutor{
        private Queue<Callback> callbackQueue = new LinkedList();
        public void execute(Callback callback){
            callbackQueue.add(callback);

        }
        public void run(){
            callbackQueue.forEach(callback -> callback.callback());
        }
    }

    public void asyac(){
        //异步回掉
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(()->{
            System.out.println("123");
        });

        System.out.println("ABC");

        executorService.shutdown();
    }
}


