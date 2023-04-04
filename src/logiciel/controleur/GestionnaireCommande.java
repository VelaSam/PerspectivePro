package logiciel.controleur;

import logiciel.memento.MementoIF;
import logiciel.modele.CurrentProjectState;

import java.util.Stack;

public class GestionnaireCommande {

    private static GestionnaireCommande instance;
    private Stack<MementoIF> pileDeCommande;
    //a chaque fois quon exectue une autre action a lexterieur de undo/redo, on vide la pile
    private Stack<MementoIF> pileDeUndo;
    private CurrentProjectState cps;


    private GestionnaireCommande(){
        this.pileDeCommande = new Stack<MementoIF>();
        this.pileDeUndo = new Stack<MementoIF>();

    }

    public static GestionnaireCommande getInstance(){

        if(instance == null){

            return instance = new GestionnaireCommande();

        }
        return instance;

    }

    private MementoIF undo(){
        return pileDeCommande.pop();
    }


    public static void setInstance(GestionnaireCommande instance) {
        GestionnaireCommande.instance = instance;
    }

    public Stack<MementoIF> getPileDeCommande() {
        return pileDeCommande;
    }

    public void setPileDeCommande(Stack<MementoIF> pileDeCommande) {
        this.pileDeCommande = pileDeCommande;
    }

    public Stack<MementoIF> getPileDeUndo() {
        return pileDeUndo;
    }

    public void setPileDeUndo(Stack<MementoIF> pileDeUndo) {
        this.pileDeUndo = pileDeUndo;
    }

    public CurrentProjectState getCps() {
        return cps;
    }

    public void setCps(CurrentProjectState cps) {
        this.cps = cps;
    }
}
