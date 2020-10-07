package org.dayrain.demo04;

/**
 * 如果创建对象的代价不大，或者没有延时创建这种需求，可以这么做
 */
public class Singleton2 {
    private static Singleton2 uniqueInstance = new Singleton2();

    private Singleton2(){}

    public Singleton2 getInstance(){
        return uniqueInstance;
    }
}
