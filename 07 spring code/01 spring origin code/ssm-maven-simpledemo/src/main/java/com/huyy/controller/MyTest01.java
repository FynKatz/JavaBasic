package com.huyy.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yyhu
 * @create 2020-12-26-19:40
 **/
public class MyTest01 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test.xml");

//        System.out.println();
//        Class<?> clazz;
//        try {
//            clazz = Class.forName("com.huyy.beans.Teacher");
//            ClassLoader classLoader = clazz.getClassLoader();
//            try {
//                Object o = clazz.newInstance();
//                System.out.println(o);
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }
}
