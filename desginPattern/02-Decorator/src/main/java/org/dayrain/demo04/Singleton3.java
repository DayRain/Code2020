package org.dayrain.demo04;

/**
 * 方法全局枷锁，效率较低
 */
public class Singleton3 {
    private static Singleton3 uniqueInstance;

    private Singleton3(){}

    public synchronized Singleton3 getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton3();
        }
        return uniqueInstance;
    }
}
