package com.fk.design;

import java.util.Optional;

/**
 *
 * 状态接口
 * @author fk
 * @date 21:33 2018/3/3
 */
public class OptionalDemo {
    public static void main(String[] args) {
        //规避空指针问题
        Optional optional = Optional.of("Hello");

        //流式写法

        System.out.println(


                optional.map(value->value+",World")//Hello;World
                .map(value->value+"2018")
                //Map/Reduce 转换，映射/聚合
        );
    }

}
