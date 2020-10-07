package org.dayrain.demo04;

/**
 * 多线程环境下，在创建对象的时候会出问题，可能会出现两个对象。
 */
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
