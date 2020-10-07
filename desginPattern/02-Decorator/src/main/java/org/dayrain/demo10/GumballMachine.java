package org.dayrain.demo10;

public class GumballMachine {

    String location;
    String state;
    Integer count;
    public GumballMachine(String location, int count) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getState() {
        return state;
    }

    public Integer getCount() {
        return count;
    }
}
