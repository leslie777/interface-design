package com.fk.design;

import java.io.Serializable;

/**
 * 标记（类属）接口
 *
 * @author fk
 * @date 20:30 2018/3/3
 */
public class MarkInterfaceDemo {
    //如String实现了CharSequence
    public static void main(String[] args) {
        //序列化
        //Hibernate Session，Jpa
        //实体（Entry） 实现序列化 Serialzable
        //PK（Primary Key） 也要实现序列化 Serialzable
        //PK（Primary Key） 的类型
        //      数值（Long;Integer;Short;Double;Float）
        //      字符类型（String）;

        Serializable value = new Long(1L);
        value = new Integer(1);
        value = new Short((short)1);
        value = new Double(1);
        value = new Float(1);
        value = new String("1");

        save(1);
        save(1L);
        save(1);
    }

    public static void save(Serializable value) {
        System.out.println();

    }

}
