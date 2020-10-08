package com.huyy.ThreadLocal;

import java.util.concurrent.TimeUnit;

/**ThreadLocal示例 */
public class ThreadLocal2 {
    static ThreadLocal<Person> tl = new ThreadLocal<>();
    
    public static void main(String[] args) {
        //线程1：打印name
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }, "t1").start();
      //线程2：修改name
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }, "t2").start();
    }
}
class Person {
    String name = "zhangsan";
}
