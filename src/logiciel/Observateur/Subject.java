package logiciel.Observateur;

import java.util.ArrayList;

public abstract class Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();


    public void attachObserver(Observer o){
        this.observers.add(o);
    };
    public void detachObserver(Observer o){
        this.observers.remove(o);
    };
    public void notifyObservers(){
        for(Observer obs: observers){
            obs.update(this);
        }
    };


}
