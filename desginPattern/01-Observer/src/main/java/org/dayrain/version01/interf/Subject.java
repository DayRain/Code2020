package org.dayrain.version01.interf;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyAllObserver();
}
