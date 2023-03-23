package logiciel.vue;

import logiciel.modele.Image;
import logiciel.modele.Perspective;

public class PanneauDynamique {

    private Image image;

    private Perspective perspective;


    public PanneauDynamique(Image image, Perspective perspective) {
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
