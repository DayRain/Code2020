package org.dayrain.demo04;

/**
 * 通过局部加锁的方式，在保证效率的前提下，确保高并发情况下的可靠性
 */
public class Singleton4 {
    //volatile 确保uniqueInstance被初始化的时候，多个线程能正确的处理该变量。仅适用于java1.5及以后
    private static volatile Singleton4 uniqueInstance;

    private Singleton4(){}

    public Singleton4 getInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton4.class){
                uniqueInstance = new Singleton4();
            }
        }
        return uniqueInstance;
    }
}
