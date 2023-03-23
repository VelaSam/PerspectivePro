package logiciel.controleur;

import logiciel.memento.Memento;

import java.util.Stack;

public class GestionnaireCommande {

    private GestionnaireCommande instance;
    private Stack<Memento> pileDeCommande;
    //a chaque fois quon exectue une autre action a lexterieur de undo/redo, on vide la pile
    private Stack<Memento> pileDeUndo;


    private GestionnaireCommande(){
        //TODO: Faire constructeur
    }

    public GestionnaireCommande getInstance(){

        if(instance == null){
            return new GestionnaireCommande();
        }
        return this.instance;

    }

    private Memento undo(){
        return pileDeCommande.pop();
    }




}
