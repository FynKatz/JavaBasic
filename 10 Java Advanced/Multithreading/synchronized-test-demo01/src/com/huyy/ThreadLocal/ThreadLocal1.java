//package com.huyy.ThreadLocal;
//
//import java.util.concurrent.TimeUnit;
//
///**引例 */
//public class ThreadLocal1 {
//    volatile static Person p = new Person();
//    
//    public static void main(String[] args) {
//        //线程1：打印name
//        new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(p.name);
//        }, "t1").start();
//      //线程2：修改name
//        new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            p.name = "lisi";
//        }, "t2").start();
//    }
//}
//class Person {
//    String name = "zhangsan";
//}
