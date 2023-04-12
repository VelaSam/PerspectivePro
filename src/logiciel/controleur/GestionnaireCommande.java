package logiciel.controleur;

import logiciel.memento.MementoIF;
import logiciel.modele.CurrentProjectState;
import logiciel.vue.VerticalBoxPrincipal;

import java.util.Stack;

/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: GestionnaireCommande.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-05
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-03-30 Implementation de la classe premiere version
 2023-04-05 Implementation de la classe derniere version

 *******************************************************/

public class GestionnaireCommande {

    private static GestionnaireCommande instance;
    private Stack<MementoIF> pileDeCommande;
    //a chaque fois quon exectue une autre action a lexterieur de undo/redo, on vide la pile
    private Stack<MementoIF> pileDeUndo;
    private CurrentProjectState cps;
    private VerticalBoxPrincipal verticalBoxPrincipal;


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

    public MementoIF undo(){
        if(!this.pileDeCommande.empty()){

//            this.pileDeUndo.add(pileDeCommande.peek());

            return pileDeCommande.pop();

        }
        return null;
    }

    public MementoIF redo(){
        if(!this.pileDeUndo.empty()){

//            this.pileDeCommande.add(pileDeUndo.peek());
            return pileDeUndo.pop();
        }
        return null;
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

    public VerticalBoxPrincipal getVerticalBoxPrincipal() {
        return verticalBoxPrincipal;
    }

    public void setVerticalBoxPrincipal(VerticalBoxPrincipal verticalBoxPrincipal) {
        this.verticalBoxPrincipal = verticalBoxPrincipal;
    }
}
