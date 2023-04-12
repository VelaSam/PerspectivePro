package logiciel.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logiciel.observateur.Observer;
import logiciel.observateur.Subject;
import logiciel.controleur.GestionnaireCommande;
import logiciel.modele.ImageContainer;


/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: PanneauStatique.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-02
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-03-23 getters et setters
 2023-04-02 implementation


 *******************************************************/

public class PanneauStatique extends AbstractPanneau implements Observer {

    private ImageContainer imageContainer;

    public PanneauStatique(ImageContainer imageContainer) {
        super();
        this.imageContainer = imageContainer;
        super.getChildren().add(imageContainer.getImageView());

    }

    public ImageContainer getImage() {
        return imageContainer;
    }

    public void setImage(ImageContainer imageContainer) {
        this.imageContainer = imageContainer;
    }

    public ImageView getImageView() {
        return this.imageContainer.getImageView();
    }



    @Override
    public void update(Subject s) {

    }
}
