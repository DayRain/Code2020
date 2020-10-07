package org.dayrain.demo03.factory2;

import org.dayrain.demo03.Pizza;
import org.dayrain.demo03.simplefactory.PizzaStore;
import org.dayrain.demo03.simplefactory.SimplePizzaFactory;

public abstract class PizzaStore2 {

    public void OrderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    abstract Pizza createPizza(String type);
}
