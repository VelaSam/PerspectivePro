package logiciel.controleur;

import javafx.stage.FileChooser;
import logiciel.commande.Commande;
import logiciel.commande.CommandeCharger;
import logiciel.vue.VerticalBoxPrincipal;

import java.io.File;

public class Controleur {

    private VerticalBoxPrincipal vbp;
    private Commande commande;

    public Controleur(VerticalBoxPrincipal vbp){
        this.vbp = vbp;
        this.initActionButtons();

    }
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

    public VerticalBoxPrincipal getVbp() {
        return vbp;
    }

    private void initActionButtons(){
    // Initialiser tout les actions des boutons de VBP
        vbp.getBoutonCharger().setOnAction(e ->{
            this.setCommande(new CommandeCharger());
            this.executeCommand();
        });

    }

}
