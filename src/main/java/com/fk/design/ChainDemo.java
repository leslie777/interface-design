package com.fk.design;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 链式设计 (责任连模式)示例
 * @author fk
 * @date 21:13 2018/3/3
 */
public class ChainDemo {
    //Mybatis 拦截器 servlet 过滤器
    //执行者
    //Chain



    public interface Executor{
        void execute(ExecutorChain chain);
    }


    public interface ExecutorChain{
        void execute();
    }

    public static class DefaultExecutorChain implements ExecutorChain{
        //[0]->[1]->[2]
        private final List<Executor> executorList = new LinkedList();
        /**
         * 当前执行的位置
         */
        private int position = 0;

        /**
         * 增加链条上的节点
         */
        public void addExecutor(Executor executor){
            executorList.add(executor);
        }

        @Override
        public void execute(){
            //position = 0 => position = 1;
            int pos = position;
            Executor executor = executorList.get(pos);
            System.out.println("执行到地"+pos+"个Executor元素");
            position ++;
            //将调用链传入，执行下一个
            executor.execute(this);
        }
    }

    public static void main(String[] args) {
        //过滤器
        //流水线 PipeLine
        //tream 流处理
        ExecutorChain chain = new DefaultExecutorChain();
        chain.addExecutor(new Executor(){
            @Override
            public void execute(ExecutorChain chain){
                System.out.println("");
                //下一个
                chain.execute();
            }
        });
        chain.addExecutor(
                (c)->{
                    System.out.println("ABC");
                }
        );

    }
}
