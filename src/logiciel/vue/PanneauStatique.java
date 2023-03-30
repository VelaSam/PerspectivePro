package logiciel.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logiciel.Observateur.Observer;
import logiciel.Observateur.Subject;
import logiciel.controleur.GestionnaireCommande;
import logiciel.modele.ImageContainer;

public class PanneauStatique extends AbstractPanneau implements Observer {

    private ImageContainer imageContainer;

    private ImageView imageView;


    public PanneauStatique(ImageContainer imageContainer, ImageView imageView) {
        super();
        this.imageContainer = imageContainer;
        this.imageView = imageView;
    }

    public ImageContainer getImage() {
        return imageContainer;
    }

    public void setImage(ImageContainer imageContainer) {
        this.imageContainer = imageContainer;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void update(Subject s) {
        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        imageView.setImage(gc.getCps().getCurrentProjectImage().getImage());
    }
}
