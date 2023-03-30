package logiciel.vue;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import logiciel.modele.Image;
import logiciel.modele.Perspective;

public class PanneauDynamique extends AbstractPanneau {

    private Image image;
    private Border paneBackgound;
    private ImageView currentImageView;
    private Perspective perspective;



    public PanneauDynamique(Image image, Perspective perspective) {
        super();
        this.image = image;
        this.perspective = perspective;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Perspective getPerspective() {
        return perspective;
    }

    public void setPerspective(Perspective perspective) {
        this.perspective = perspective;
    }
}
