package logiciel.controleur;

import javafx.stage.FileChooser;
import logiciel.commande.*;
import logiciel.memento.MementoIF;
import logiciel.modele.CurrentProjectState;
import logiciel.vue.VerticalBoxPrincipal;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public class Controleur {

    private VerticalBoxPrincipal vbp;
    private Commande commande;


    private AtomicReference<Double> ecartHM = new AtomicReference<>((double) 0);
    private AtomicReference<Double> ecartVM = new AtomicReference<>((double) 0);
    private AtomicReference<Double> ecartHD = new AtomicReference<>((double) 0);
    private AtomicReference<Double> ecartVD = new AtomicReference<>((double) 0);

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
            GestionnaireCommande gc = GestionnaireCommande.getInstance();
            MementoIF memento = gc.getCps().save();
            gc.getPileDeCommande().add(memento);

            ecartHM.set(vbp.getPanneauMilieu().getPerspective().getImageView().getX()-e.getX());
            ecartVM.set(vbp.getPanneauMilieu().getPerspective().getImageView().getY()-e.getY());
        });


        vbp.getPanneauDroite().getPerspective().getImageView().setOnMousePressed(e->{
            GestionnaireCommande gc = GestionnaireCommande.getInstance();
            MementoIF memento = gc.getCps().save();
            gc.getPileDeCommande().add(memento);

            ecartHD.set(vbp.getPanneauDroite().getPerspective().getImageView().getX()-e.getX());
            ecartVD.set(vbp.getPanneauDroite().getPerspective().getImageView().getY()-e.getY());
        });

        vbp.getPanneauMilieu().getPerspective().getImageView().setOnMouseDragged(e->{
            this.setCommande(new CommandTranslate(e, vbp.getPanneauMilieu().getPerspective().getImageView(),ecartHM.get(), ecartVM.get()));
            this.executeCommand();
        });

        vbp.getPanneauDroite().getPerspective().getImageView().setOnMouseDragged(e->{
            this.setCommande(new CommandTranslate(e, vbp.getPanneauDroite().getPerspective().getImageView(),ecartHD.get(),ecartVD.get()));
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
