package logiciel.commande;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import logiciel.controleur.GestionnaireCommande;
import logiciel.memento.MementoIF;
import logiciel.modele.Perspective;
import logiciel.vue.AbstractPanneau;

import java.util.concurrent.atomic.AtomicReference;

public class CommandTranslate implements Commande{

    private Perspective perspective;
    private MouseEvent event;
    private double ecartH;
    private double ecartV;

    public CommandTranslate(MouseEvent event, Perspective perspective, double ecartH, double ecartV){
        this.perspective = perspective;
        this.event = event;
        this.ecartH = ecartH;
        this.ecartV = ecartV;
    }
    @Override
    public void execute() {
        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        double positionX = event.getX()+ ecartH;
        double positionY = event.getY()+ ecartV;
        //System.out.println("Pourcentage Zoom: "+ perspective.getZoomPourcentage());
        System.out.println("Position X:"+gc.getCps().getPerspectiveMilieu().getPositionX());
        System.out.println("Largeur: "+ gc.getCps().getPerspectiveMilieu().getImageView().getFitWidth());
        perspective.setPositionX(positionX);
        perspective.setPositionY(positionY);




    }
}
