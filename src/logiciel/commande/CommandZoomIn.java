package logiciel.commande;

import javafx.scene.input.ScrollEvent;
import logiciel.controleur.GestionnaireCommande;
import logiciel.modele.CurrentProjectState;

public class CommandZoomIn implements Commande{

   private ScrollEvent e;
   private int perspective;



    public CommandZoomIn(ScrollEvent e, int perspective){
        this.e = e;
        this.perspective = perspective;
    }
    @Override
    public void execute() {
        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        if(perspective == CurrentProjectState.CURRENT_PERSPECTIVE_MILIEU){
            //seulement dezoomer si le zoompourcentage reste plus grand que 0
            if(gc.getCps().getPerspectiveMilieu().getZoomPourcentage()+0.1 > 0){

                gc.getCps().getPerspectiveMilieu().setZoomPourcentage(
                        gc.getCps().getPerspectiveMilieu().getZoomPourcentage()+0.1
                );
            }
        } else if(perspective == CurrentProjectState.CURRENT_PERSPECTIVE_DROITE){
            if(gc.getCps().getPerspectiveDroite().getZoomPourcentage()+0.1 > 0){

                gc.getCps().getPerspectiveDroite().setZoomPourcentage(
                        gc.getCps().getPerspectiveDroite().getZoomPourcentage()+0.1
                );
            }
        }
    }
}
