package logiciel.vue;

import javafx.scene.image.ImageView;
import logiciel.modele.Image;

public class PanneauStatique {

    private Image image;

    private ImageView imageView;


    public PanneauStatique(Image image, ImageView imageView) {
        this.image = image;
        this.imageView = imageView;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
