package logiciel.commande;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import logiciel.controleur.GestionnaireCommande;
import logiciel.memento.MementoIF;

import java.util.concurrent.atomic.AtomicReference;

public class CommandTranslate implements Commande{

    private ImageView currentImageView;
    private MouseEvent event;

    public CommandTranslate(MouseEvent event, ImageView imageView){
        this.currentImageView = imageView;
        this.event = event;
    }
    @Override
    public void execute() {


        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        MementoIF memento = gc.getCps().save();
        gc.getPileDeCommande().add(memento);




        AtomicReference<Double> ecartH = new AtomicReference<>((double) 0);
        AtomicReference<Double> ecartV = new AtomicReference<>((double) 0);

        currentImageView.setOnMousePressed(event -> {

            ecartH.set(currentImageView.getX()-event.getX());
            ecartV.set(currentImageView.getY()-event.getY());


            currentImageView.setOnMouseDragged(e -> {
                double positionX = e.getX()+ecartH.get();
                double positionY = e.getY()+ecartV.get();
                double ecartX =currentImageView.getX()-e.getX();
                double ecartY =currentImageView.getY()-e.getY();


                if(positionX >= 0 ){
                    currentImageView.setX(positionX);
                }else{
                    ecartH.set(ecartX);
                }

                if(positionY>=0){
                    currentImageView.setY(positionY);
                }else{
                    ecartV.set(ecartY);
                }


        });

        });
    }
}
