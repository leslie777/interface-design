package com.fk.design;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * {@link java.util.concurrent.ExecutorService} 示例
 * 执行接口 执行于返回。借鉴callable
 * @author fk
 * @date 20:40 2018/3/3
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) throws Exception{
        //Runnabke 接口，Callable接口
        //假设Runnabe(设计反例，设计接口要考虑正常异常的返回)在JDK1.1时，提供 throws Exception
        //程序在JDK 1.0运行时，出现不兼容

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        });

        executorService.execute(()-> System.out.println(""));
        executorService.execute(()->{
                    throw new RuntimeException("hello");
                }
        );

        //Throwable : Exception\Error 父类
        Future<String> future = executorService.submit(
                ()-> {
                    System.out.println("callable");
                }
        );
        //Checked 异常:需要明确在方法签名
        //Unchecked 异常；不强制才方法签名出现，建议还是出现,NullPointerException
        future.get();

        future.cancel(true);

        executorService.shutdown();

        System.out.println("Complete...");

    }

}
