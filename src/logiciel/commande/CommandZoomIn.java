package logiciel.commande;

import javafx.scene.input.ScrollEvent;
import logiciel.controleur.GestionnaireCommande;
import logiciel.modele.CurrentProjectState;
import logiciel.vue.AbstractPanneau;

/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: CommandeZoomIn.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-10
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-04-10 Implementation de la classe
 *******************************************************/

public class CommandZoomIn implements Commande{

   private ScrollEvent e;
   private int perspective;



    public CommandZoomIn(ScrollEvent e, int perspective){
        this.e = e;
        this.perspective = perspective;
    }
    @Override
    public void execute() {
        //Grand problème, car utilisation de hard codage
        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        if(perspective == CurrentProjectState.CURRENT_PERSPECTIVE_MILIEU
        && gc.getCps().getPerspectiveMilieu().getZoomPourcentage()+0.05 > 0
                && gc.getCps().getPerspectiveMilieu().getPositionX()
                +gc.getCps().getPerspectiveMilieu().getImageView().getImage().getWidth()*gc.getCps().getPerspectiveMilieu().getZoomPourcentage()
                +0.05 < AbstractPanneau.WIDTH-7.5
                && gc.getCps().getPerspectiveMilieu().getPositionY()
                +gc.getCps().getPerspectiveMilieu().getImageView().getImage().getHeight()*gc.getCps().getPerspectiveMilieu().getZoomPourcentage()
                +0.05< AbstractPanneau.HEIGHT-9){




                gc.getCps().getPerspectiveMilieu().setZoomPourcentage(
                        gc.getCps().getPerspectiveMilieu().getZoomPourcentage()+0.05
                );
                gc.getCps().getPerspectiveMilieu().getImageView().setFitWidth(gc.getCps().getPerspectiveMilieu().getImageView().getImage().getWidth()*gc.getCps().getPerspectiveMilieu().getZoomPourcentage());
                gc.getCps().getPerspectiveMilieu().getImageView().setFitHeight(gc.getCps().getPerspectiveMilieu().getImageView().getImage().getHeight()*gc.getCps().getPerspectiveMilieu().getZoomPourcentage());

        } else if(perspective == CurrentProjectState.CURRENT_PERSPECTIVE_DROITE &&
                gc.getCps().getPerspectiveDroite().getZoomPourcentage()+0.05 > 0
                && gc.getCps().getPerspectiveDroite().getPositionX()
                +gc.getCps().getPerspectiveDroite().getImageView().getImage().getWidth()*gc.getCps().getPerspectiveDroite().getZoomPourcentage()
                +0.05 < AbstractPanneau.WIDTH-7.5
                && gc.getCps().getPerspectiveDroite().getPositionY()
                +gc.getCps().getPerspectiveDroite().getImageView().getImage().getHeight()*gc.getCps().getPerspectiveDroite().getZoomPourcentage()
                +0.05< AbstractPanneau.HEIGHT-9){


                gc.getCps().getPerspectiveDroite().setZoomPourcentage(
                        gc.getCps().getPerspectiveDroite().getZoomPourcentage()+0.05
                );
                gc.getCps().getPerspectiveDroite().getImageView().setFitWidth(gc.getCps().getPerspectiveDroite().getImageView().getImage().getWidth()*gc.getCps().getPerspectiveDroite().getZoomPourcentage());
                gc.getCps().getPerspectiveDroite().getImageView().setFitHeight(gc.getCps().getPerspectiveDroite().getImageView().getImage().getHeight()*gc.getCps().getPerspectiveDroite().getZoomPourcentage());

        }
    }
}
