package logiciel.controleur;

import logiciel.memento.Memento;
import logiciel.modele.CurrentProjectState;

import java.util.Stack;

public class GestionnaireCommande {

    private static GestionnaireCommande instance;
    private Stack<Memento> pileDeCommande;
    //a chaque fois quon exectue une autre action a lexterieur de undo/redo, on vide la pile
    private Stack<Memento> pileDeUndo;
    private CurrentProjectState cps;


    private GestionnaireCommande(){
        this.pileDeCommande = new Stack<Memento>();
        this.pileDeUndo = new Stack<Memento>();

    }

    public static GestionnaireCommande getInstance(){

        if(instance == null){

            return instance = new GestionnaireCommande();

        }
        return instance;

    }

    private Memento undo(){
        return pileDeCommande.pop();
    }


    public static void setInstance(GestionnaireCommande instance) {
        GestionnaireCommande.instance = instance;
    }

    public Stack<Memento> getPileDeCommande() {
        return pileDeCommande;
    }

    public void setPileDeCommande(Stack<Memento> pileDeCommande) {
        this.pileDeCommande = pileDeCommande;
    }

    public Stack<Memento> getPileDeUndo() {
        return pileDeUndo;
    }

    public void setPileDeUndo(Stack<Memento> pileDeUndo) {
        this.pileDeUndo = pileDeUndo;
    }

    public CurrentProjectState getCps() {
        return cps;
    }

    public void setCps(CurrentProjectState cps) {
        this.cps = cps;
    }
}
