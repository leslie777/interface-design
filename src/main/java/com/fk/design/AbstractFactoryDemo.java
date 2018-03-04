package com.fk.design;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 *
 * @link ThreadFactory 实例
 * 创建接口
 * 抽象工厂
 * @author fk
 * @date 20:15 2018/3/3
 */
public class AbstractFactoryDemo {
    //1.接口或抽象类
    //2.创建实例
    //3.必须是抽象方法

    //ThreadFactory
    public static void main(String[] args) {
        //maven默认
        ThreadFactory factory = (r)->{
            return new Thread(r);
        };

        ThreadFactory factory1 = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable);
            }
        };
        Thread thread = factory.newThread(()->{
            System.out.println("");
        });


        thread.start();
        //上面是抽象工厂，下面是工厂模式
        ExecutorService executorService = Executors.newSingleThreadExecutor(factory);

        executorService.execute(()-> System.out.println("123"));
        executorService.shutdown();
    }
}
