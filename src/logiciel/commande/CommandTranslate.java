package logiciel.commande;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import logiciel.controleur.GestionnaireCommande;
import logiciel.memento.MementoIF;

import java.util.concurrent.atomic.AtomicReference;

public class CommandTranslate implements Commande{

    private ImageView currentImageView;
    private MouseEvent event;
    private double ecartH;
    private double ecartV;

    public CommandTranslate(MouseEvent event, ImageView imageView, double ecartH, double ecartV){
        this.currentImageView = imageView;
        this.event = event;
        this.ecartH = ecartH;
        this.ecartV = ecartV;
    }
    @Override
    public void execute() {



                double positionX = event.getX()+ ecartH;
                double positionY = event.getY()+ ecartV;

                //Prendre positionX et additioner une rapport du zoom avec le scale
                if(positionX >= 0 ){
                    currentImageView.setX(positionX);
                }

                if(positionY>=0){
                    currentImageView.setY(positionY);
                }



    }
}
