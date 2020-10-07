package org.dayrain.demo07;

import java.util.Enumeration;

public class Coffee extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("brewCoffeeGrinds");
    }

    @Override
    void addCondiments() {
        System.out.println("addSugarAndMilk");
    }

    public static void main(String[] args) {

    }
}
