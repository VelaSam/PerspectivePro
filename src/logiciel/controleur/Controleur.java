package logiciel.controleur;

import javafx.stage.FileChooser;
import logiciel.commande.*;
import logiciel.modele.CurrentProjectState;
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

        vbp.getPanneauMilieu().getPerspective().getImageView().setOnMousePressed(e->{
            this.setCommande(new CommandTranslate(e, vbp.getPanneauMilieu().getPerspective().getImageView()));
            this.executeCommand();
        });

        vbp.getPanneauDroite().getPerspective().getImageView().setOnMousePressed(e->{
            this.setCommande(new CommandTranslate(e, vbp.getPanneauDroite().getPerspective().getImageView()));
            this.executeCommand();
        });

        vbp.getPanneauMilieu().getPerspective().getImageView().setOnScroll(e ->{
            //zoom
            if(e.getDeltaY() > 0){
                this.setCommande(new CommandZoomIn(e, CurrentProjectState.CURRENT_PERSPECTIVE_MILIEU));
                this.executeCommand();

                //dezoom
            }else if(e.getDeltaY() < 0){
                this.setCommande(new CommandZoomOut(e, CurrentProjectState.CURRENT_PERSPECTIVE_MILIEU));
                this.executeCommand();
            }
        });

        vbp.getPanneauDroite().getPerspective().getImageView().setOnScroll(e ->{
            //zoom
            if(e.getDeltaY() > 0){
                this.setCommande(new CommandZoomIn(e, CurrentProjectState.CURRENT_PERSPECTIVE_DROITE));
                this.executeCommand();

                //dezoom
            }else if(e.getDeltaY() < 0){
                this.setCommande(new CommandZoomOut(e, CurrentProjectState.CURRENT_PERSPECTIVE_DROITE));
                this.executeCommand();
            }
        });

        vbp.getBoutonUndo().setOnAction(e ->{

            this.setCommande(new CommandUndo());
            this.executeCommand();
        });

    }

}
