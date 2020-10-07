package org.dayrain.version03.impl;

import org.dayrain.version03.interf.DisplayMessage;
import org.dayrain.version03.interf.Observer;

public class Student implements DisplayMessage, Observer {
    private String msg;
    @Override
    public void update(String msg) {
        ;this.msg = msg;
        show(msg);
    }

    @Override
    public void show(String msg) {
        System.out.println("msg is " + msg);
    }
}
