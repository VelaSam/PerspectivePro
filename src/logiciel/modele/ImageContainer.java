package logiciel.modele;

import javafx.scene.image.Image;
import logiciel.Observateur.Observer;
import logiciel.Observateur.Subject;

import java.util.ArrayList;

public class ImageContainer  extends Subject {

    private String path;
    private Image image;

    public ImageContainer(String path) {



        this.path = path;
        this.image = new Image(this.path);
    }

    public ImageContainer clone() {
        return new ImageContainer(this.path);
    }
    public void changeImage(String path){
        this.path = path;
        this.image = new Image(path);
        this.notifyObservers();

    }

    public Image getImage(){
        return this.image;
    }
    public String getPath(){
        return this.path;
    }

}
