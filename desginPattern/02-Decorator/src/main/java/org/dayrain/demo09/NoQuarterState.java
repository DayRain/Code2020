package org.dayrain.demo09;

public class NoQuarterState implements State{
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你给了钱");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你还没有给钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("你点需要，但是没给钱");
    }

    @Override
    public void dispense() {
        System.out.println("你点了发放，但是没给钱");
    }
}
