package logiciel.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logiciel.observateur.Observer;
import logiciel.observateur.Subject;
import logiciel.controleur.GestionnaireCommande;
import logiciel.modele.ImageContainer;

public class PanneauStatique extends AbstractPanneau implements Observer {

    private ImageContainer imageContainer;

    public PanneauStatique(ImageContainer imageContainer) {
        super();
        this.imageContainer = imageContainer;
        super.getChildren().add(imageContainer.getImageView());

    }

    public ImageContainer getImage() {
        return imageContainer;
    }

    public void setImage(ImageContainer imageContainer) {
        this.imageContainer = imageContainer;
    }

    public ImageView getImageView() {
        return this.imageContainer.getImageView();
    }



    @Override
    public void update(Subject s) {

        GestionnaireCommande gc = GestionnaireCommande.getInstance();
        this.imageContainer.getImageView().setImage(new Image("file:/"+gc.getCps().getCurrentProjectImage().getPath()));
        this.imageContainer.getImageView().setFitWidth(this.imageContainer.getImageView().getImage().getWidth());
        this.imageContainer.getImageView().setFitHeight(this.imageContainer.getImageView().getImage().getHeight());
        
//        super.getChildren().clear();
//        super.getChildren().add(imageContainer.getImageView());




    }
}
