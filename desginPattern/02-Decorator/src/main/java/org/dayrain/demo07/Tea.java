package org.dayrain.demo07;

public class Tea extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("steepTeaBag");

    }

    @Override
    void addCondiments() {
        System.out.println("addLemon");

    }
}
