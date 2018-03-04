package com.fk.design;

/**
 * @author fk
 * @date 21:41 2018/3/3
 */
public class LambdaDemo {
    public static void main(String[] args) {
        echo(()->"helloworld");//替换实现
    }

    private static void echo(Valuable<?> valuable){
        System.out.println(valuable.get());
    }


    //函数接口
    @FunctionalInterface
    public static interface Valuable<V>{

        V get();

    }
}
