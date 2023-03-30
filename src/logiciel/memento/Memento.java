package logiciel.memento;

import logiciel.modele.Image;
import logiciel.modele.Perspective;

public class Memento {

    Image currentProjectImage;
    Perspective perspectiveMilieu;
    Perspective perspectiveDroite;

    public Memento(Image currentProjectImage, Perspective perspectiveMilieu, Perspective perspectiveDroite) {

        this.currentProjectImage = currentProjectImage.clone();
        this.perspectiveMilieu = perspectiveMilieu.clone();
        this.perspectiveDroite = perspectiveDroite.clone();

    }


    public Image getMementoProjectImage() {
        return currentProjectImage;
    }

    public Perspective getMementoPerspectiveMilieu() {
        return perspectiveMilieu;
    }

    public Perspective getMementoPerspectiveDroite() {
        return perspectiveDroite;
    }
}


