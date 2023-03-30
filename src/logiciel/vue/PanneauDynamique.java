package logiciel.vue;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import logiciel.Observateur.Observer;
import logiciel.Observateur.Subject;
import logiciel.controleur.GestionnaireCommande;
import logiciel.modele.CurrentProjectState;
import logiciel.modele.ImageContainer;
import logiciel.modele.Perspective;

public class PanneauDynamique extends AbstractPanneau implements Observer {

    private ImageContainer imageContainer;
    private Border paneBackgound;
    private ImageView currentImageView;
    private Perspective perspective;



    public PanneauDynamique(ImageContainer imageContainer, Perspective perspective) {
        super();
        this.imageContainer = imageContainer;
        this.perspective = perspective;
    }

    public ImageContainer getImage() {
        return imageContainer;
    }

    public void setImage(ImageContainer imageContainer) {
        this.imageContainer = imageContainer;
    }

    public Perspective getPerspective() {
        return perspective;
    }

    public void setPerspective(Perspective perspective) {
        this.perspective = perspective;
    }

    @Override
    public void update(Subject s) {
        GestionnaireCommande gc = GestionnaireCommande.getInstance();
        if(s instanceof CurrentProjectState){
            this.imageContainer.changeImage(((CurrentProjectState) s).getCurrentProjectImage().getPath());
        }
    }
}
