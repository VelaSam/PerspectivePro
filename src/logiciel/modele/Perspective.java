package logiciel.modele;

import javafx.scene.image.ImageView;
import logiciel.observateur.Subject;
import logiciel.vue.AbstractPanneau;

import java.io.Serializable;

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
        super.notifyObservers();
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
        notifyObservers();
    }
}
