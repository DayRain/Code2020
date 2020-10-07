package org.dayrain.version03.impl;

public class School {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student();
        teacher.registerObserver(student);
        teacher.speakWord("hello");
    }
}
