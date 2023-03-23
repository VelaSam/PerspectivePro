package logiciel.controleur;

import logiciel.commande.Commande;

public class Controleur {


    Commande commande;


    public void executeCommand(){
        commande.execute();
    }

    public void initSauvegarde(){
        //TODO: cette methode
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Commande getCommande() {
        return commande;
    }

}
