package logiciel.memento;

import logiciel.modele.CurrentProjectState;
import logiciel.modele.Image;
import logiciel.modele.Perspective;

public class Memento {

    Image currentProjectImage;
    Perspective perspectiveMilieu;
    Perspective perspectiveDroite;

    /*

        '{static}+PERSPECTIVE_CENTRE
        '{static}+PERSPECTIVE_DROITE

        -image: currentProjectImage
        -perspectiveMilieu: Perspective
        -perspectiveDroite: Perspective

        'Constructeur'
        +Memento(image, perspectiveMilieu, perspectiveDroite)
        'Getters du memento'
        +getImage()
        +getPerspectiveMilieu()
        +getPerspectiveDroite()
     */


    public Memento(Image currentProjectImage, Perspective perspectiveMilieu, Perspective perspectiveDroite) throws CloneNotSupportedException {

        this.currentProjectImage = currentProjectImage.clone();
        this.perspectiveMilieu = perspectiveMilieu.clone();
        this.perspectiveDroite = perspectiveDroite.clone();


    }


    public Image getCurrentProjectImage() {
        return currentProjectImage;
    }

    public Perspective getPerspectiveMilieu() {
        return perspectiveMilieu;
    }

    public Perspective getPerspectiveDroite() {
        return perspectiveDroite;
    }
}


