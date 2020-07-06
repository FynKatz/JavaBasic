package com.huyy.singleton;

/*双重检查锁实现单例模式--不建议使用*/
public class Singleton03 { 

  private static Singleton03 instance = null; 

  public static Singleton03 getInstance() { 
    if (instance == null) { 
      Singleton03 sc; 
      synchronized (Singleton03.class) { 
        sc = instance; 
        if (sc == null) { 
          synchronized (Singleton03.class) { 
            if(sc == null) { 
              sc = new Singleton03(); 
            } 
          } 
          instance = sc; 
        } 
      } 
    } 
    return instance; 
  } 

  private Singleton03() { 

  } 
    
}
