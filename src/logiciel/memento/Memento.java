package logiciel.memento;

import logiciel.modele.ImageContainer;
import logiciel.modele.Perspective;

public class Memento {

    ImageContainer currentProjectImageContainer;
    Perspective perspectiveMilieu;
    Perspective perspectiveDroite;

    public Memento(ImageContainer currentProjectImageContainer, Perspective perspectiveMilieu, Perspective perspectiveDroite) {

        this.currentProjectImageContainer = currentProjectImageContainer.clone();
        this.perspectiveMilieu = perspectiveMilieu.clone();
        this.perspectiveDroite = perspectiveDroite.clone();

    }


    public ImageContainer getMementoProjectImage() {
        return currentProjectImageContainer;
    }

    public Perspective getMementoPerspectiveMilieu() {
        return perspectiveMilieu;
    }

    public Perspective getMementoPerspectiveDroite() {
        return perspectiveDroite;
    }
}


