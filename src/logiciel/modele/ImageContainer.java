package logiciel.modele;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logiciel.observateur.Observer;
import logiciel.observateur.Subject;

import java.io.File;
import java.util.ArrayList;

public class ImageContainer  extends Subject {

    private String path;
    private ImageView image;

    public ImageContainer(String path) {
        this.path = path;
        this.image = new ImageView("file:/"+this.path);
    }

    public ImageContainer clone() {
        return new ImageContainer(this.path);
    }
    public void changeImage(String path){

            this.image = new ImageView("file:/"+path);
            this.path = path;


        this.notifyObservers();

    }

    public ImageView getImageView(){
        return this.image;
    }
    public void setImageView(ImageView imv){
        this.image = imv;

    }
    public String getPath(){
        return this.path;
    }

}
