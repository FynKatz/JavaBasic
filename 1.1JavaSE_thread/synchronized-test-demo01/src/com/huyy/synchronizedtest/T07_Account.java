package com.huyy.synchronizedtest;

/**
 * 对写业务加锁，对读业务不加锁，容易产生脏读问题
 */
public class T07_Account {
    private String name;
    private double balance;
    
    /**设置余额*/
    public synchronized void set (String name, double balance){
        this.name = name;
        
        try {
            Thread.sleep(2000);//睡2s主要是为了让结果更明显
        } catch (Exception e) {
        }
        
        this.balance = balance;
    }
    
    /**根据名字获取余额*/
    public double get (String name){
        return this.balance;
    }
    
    public static void main(String[] args) {
        
        final T07_Account account = new T07_Account();
        //存钱
        new Thread(()->account.set("张三", 100)).start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //第一次查询
        System.out.println(account.get("张三"));
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //第二次查询
        System.out.println(account.get("张三"));
        
    }
}
