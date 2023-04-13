package logiciel.modele;

import javafx.scene.image.ImageView;
import logiciel.observateur.Subject;
import logiciel.vue.AbstractPanneau;

import java.io.Serializable;

/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: CurrentProjectState.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-03-24
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-03-24 Implementation de la classe


 *******************************************************/

public class Perspective extends Subject implements Serializable {

    private transient ImageView imageView;
    private double positionX;
    private double positionY;
    private double zoomPourcentage;

    public Perspective(ImageView imageView) {
        this.imageView = imageView;
        positionX = this.imageView.getX();
        positionY = this.imageView.getY();
        zoomPourcentage =1;
        this.imageView.setFitWidth(this.imageView.getImage().getWidth());
        this.imageView.setFitHeight(this.imageView.getImage().getHeight());
    }


    /**
     * clone en copiant les variables
     * @return nouvelle perspective
     */
    public Perspective clone() {

        ImageView newImageView = new ImageView(this.imageView.getImage());

        Perspective newPerspective = new Perspective(newImageView);
        newPerspective.setPositionX(this.positionX);
        newPerspective.setPositionY(this.positionY);
        newPerspective.setZoomPourcentage(this.zoomPourcentage);

        return newPerspective;
    }

    public void changeImage(String path){
        this.imageView = new ImageView("file:/"+path);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        if(positionX >= 0 && positionX+imageView.getFitWidth() <= AbstractPanneau.WIDTH){
            this.positionX = positionX;
            this.imageView.setX(positionX);
        }


    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        if(positionY>=0 && positionY+ imageView.getFitHeight()<= AbstractPanneau.HEIGHT){
            this.positionY = positionY;
            this.imageView.setY(positionY);
        }

    }

    public double getZoomPourcentage() {
        return zoomPourcentage;
    }

    public void setZoomPourcentage(double zoomPourcentage) {
        this.zoomPourcentage = zoomPourcentage;
    }
}
