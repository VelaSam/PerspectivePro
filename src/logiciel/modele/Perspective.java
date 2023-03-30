package logiciel.modele;

import javafx.scene.image.ImageView;
import logiciel.Observateur.Subject;

public class Perspective extends Subject {

    private ImageView imageView;
    private double positionX;
    private double positionY;
    private double zoomPourcentage;

    public Perspective(ImageView imageView) {
        this.imageView = imageView;
        positionX = 0;
        positionY = 0;
        zoomPourcentage = 100;
    }

    public Perspective clone() {

        ImageView newImageView = new ImageView(this.imageView.getImage());

        Perspective newPerspective = new Perspective(newImageView);
        newPerspective.setPositionX(this.positionX);
        newPerspective.setPositionY(this.positionY);
        newPerspective.setZoomPourcentage(this.zoomPourcentage);

        return newPerspective;
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
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getZoomPourcentage() {
        return zoomPourcentage;
    }

    public void setZoomPourcentage(double zoomPourcentage) {
        this.zoomPourcentage = zoomPourcentage;
    }
}
