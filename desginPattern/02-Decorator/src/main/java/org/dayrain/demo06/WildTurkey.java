package org.dayrain.demo06;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("wild turkey gobble");
    }

    @Override
    public void fly() {
        System.out.println("wild turkey fly");
    }
}
