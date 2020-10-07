package org.dayrain.version03.interf;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyAllObservers();
}
