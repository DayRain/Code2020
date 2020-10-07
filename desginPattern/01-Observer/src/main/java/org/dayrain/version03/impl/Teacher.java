package org.dayrain.version03.impl;

import org.dayrain.version03.interf.Observer;
import org.dayrain.version03.interf.Subject;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements Subject {

    List<Observer>observers;
    private String msg;

    public Teacher(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if(index >= 0 ){
            observers.remove(o);
        }
    }


    public void speakWord(String msg){
        this.msg = msg;
        notifyAllObservers();
    }

    @Override
    public void notifyAllObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(msg);
        }
    }
}
