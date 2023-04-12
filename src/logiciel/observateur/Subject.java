package logiciel.observateur;

import java.util.ArrayList;

/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: Subject.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-03-22
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe


 *******************************************************/

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
   public void clearObservers(){
       this.observers.clear();
   }
}
