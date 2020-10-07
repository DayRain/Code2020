package org.dayrain.demo01;

public class Mocha extends CondimentDecorator {
    //保存加工前的状态
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "+Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

}
