package logiciel.modele;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logiciel.observateur.Observer;
import logiciel.observateur.Subject;
import org.omg.CORBA.Current;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;


/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: ImageContainer.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-11
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-03-24 Implementation des fonctions (ne marche pas)
 2023-04-01 modification memento
 2023-04-11 finalisation


 *******************************************************/
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
