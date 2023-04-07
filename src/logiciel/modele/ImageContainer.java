package logiciel.modele;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logiciel.observateur.Observer;
import logiciel.observateur.Subject;
import org.omg.CORBA.Current;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class ImageContainer  extends Subject implements Serializable {

    private String path;
    private transient ImageView image;

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
    public void setPath(String path){
        this.path = path;
    }
}
