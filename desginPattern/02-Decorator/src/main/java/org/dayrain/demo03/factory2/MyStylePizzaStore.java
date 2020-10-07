package org.dayrain.demo03.factory2;

import org.dayrain.demo03.CheesePizza;
import org.dayrain.demo03.ClamPizza;
import org.dayrain.demo03.PepperoniPizza;
import org.dayrain.demo03.Pizza;

public class MyStylePizzaStore extends PizzaStore2{

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if("CheesePizza".equals(type)){
            pizza = new CheesePizza();
        }else if("ClamPizza".equals(type)){
            pizza = new ClamPizza();
        }else if("PepperoniPizza".equals(type)){
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
