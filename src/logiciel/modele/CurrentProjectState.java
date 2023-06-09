package logiciel.modele;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logiciel.controleur.GestionnaireCommande;
import logiciel.memento.MementoIF;
import logiciel.observateur.Observer;
import logiciel.observateur.Subject;
import sun.net.www.content.text.Generic;

import java.io.Serializable;
import java.util.ArrayList;


/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: CurrentProjectState.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-05
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-03-24 Implementation des fonctions (ne marche pas)
 2023-04-01 modification memento
 2023-04-05 finalisation


 *******************************************************/


public class CurrentProjectState extends Subject implements Serializable {

    public static final int CURRENT_PERSPECTIVE_MILIEU = 0;
    public static final int CURRENT_PERSPECTIVE_DROITE = 1;

    private ImageContainer currentProjectImageContainer;
    private Perspective perspectiveMilieu;
    private Perspective perspectiveDroite;





    public CurrentProjectState(ImageContainer currentProjectImageContainer, Perspective perspectiveMilieu, Perspective perspectiveDroite) {
        this.currentProjectImageContainer = currentProjectImageContainer;
        this.perspectiveMilieu = perspectiveMilieu;
        this.perspectiveDroite = perspectiveDroite;



    }

    public MementoIF save(){
       return new Memento(currentProjectImageContainer, perspectiveMilieu, perspectiveDroite);
    }


    /**
     * Restaure l'état précédent des perspectives milieu et droite ainsi que de l'image du projet en cours
     * à partir d'un memento. Met à jour les positions, les tailles et les images des perspectives en
     * fonction des données contenues dans le memento.
     *
     */
    public void restore(){
        ImageView IVDroite;
        ImageView IVMilieu;
        ImageView IVGauche;

        GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();


        Memento mementoToPop = (Memento) gestionnaireCommande.undo();
        if (mementoToPop != null){
            IVDroite = this.perspectiveDroite.getImageView();
            IVMilieu = this.perspectiveMilieu.getImageView();
            IVGauche = this.currentProjectImageContainer.getImageView();

            IVDroite.setImage(new Image("file:\\"+mementoToPop.getImagePath()));
            IVMilieu.setImage(new Image("file:\\"+mementoToPop.getImagePath()));
            IVGauche.setImage(new Image("file:\\"+mementoToPop.getImagePath()));

            IVDroite.setX(mementoToPop.getxImageDroite());
            IVDroite.setY(mementoToPop.getyImageDroite());
            this.perspectiveDroite.setZoomPourcentage(mementoToPop.getZoomPourcentageImageDroite());


            IVMilieu.setX(mementoToPop.getxImageMilieu());
            IVMilieu.setY(mementoToPop.getyImageMilieu());
            this.perspectiveMilieu.setZoomPourcentage(mementoToPop.getZoomPourcentageImageMilieu());

            IVMilieu.setFitWidth(IVMilieu.getImage().getWidth()*this.perspectiveMilieu.getZoomPourcentage());
            IVMilieu.setFitHeight(IVMilieu.getImage().getHeight()*this.perspectiveMilieu.getZoomPourcentage());

            IVDroite.setFitWidth(IVDroite.getImage().getWidth()*this.perspectiveDroite.getZoomPourcentage());
            IVDroite.setFitHeight(IVDroite.getImage().getHeight()*this.perspectiveDroite.getZoomPourcentage());


        }

    }

    /**
     Restaure l'état suivant des perspectives milieu et droite ainsi que de l'image du projet en cours
     à partir d'un memento. Met à jour les positions, les tailles et les images des perspectives en
     fonction des données contenues dans le memento.
    */
    public void getBack(){

        GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();
        ImageView IVDroite;
        ImageView IVMilieu;
        ImageView IVGauche;

        Memento mementoToPop = (Memento) gestionnaireCommande.redo();
        if (mementoToPop != null){
            IVDroite = this.perspectiveDroite.getImageView();
            IVMilieu = this.perspectiveMilieu.getImageView();
            IVGauche = this.currentProjectImageContainer.getImageView();
            IVDroite.setImage(new Image("file:\\"+mementoToPop.getImagePath()));
            IVMilieu.setImage(new Image("file:\\"+mementoToPop.getImagePath()));
            IVGauche.setImage(new Image("file:\\"+mementoToPop.getImagePath()));

            IVDroite.setX(mementoToPop.getxImageDroite());
            IVDroite.setY(mementoToPop.getyImageDroite());
            this.perspectiveDroite.setZoomPourcentage(mementoToPop.getZoomPourcentageImageDroite());


            IVMilieu.setX(mementoToPop.getxImageMilieu());
            IVMilieu.setY(mementoToPop.getyImageMilieu());
            this.perspectiveMilieu.setZoomPourcentage(mementoToPop.getZoomPourcentageImageMilieu());

            IVMilieu.setFitWidth(IVMilieu.getImage().getWidth()*this.perspectiveMilieu.getZoomPourcentage());
            IVMilieu.setFitHeight(IVMilieu.getImage().getHeight()*this.perspectiveMilieu.getZoomPourcentage());

            IVDroite.setFitWidth(IVDroite.getImage().getWidth()*this.perspectiveDroite.getZoomPourcentage());
            IVDroite.setFitHeight(IVDroite.getImage().getHeight()*this.perspectiveDroite.getZoomPourcentage());

        }

    }


    public ImageContainer getCurrentProjectImage() {
        return currentProjectImageContainer;
    }


    public void setCurrentProjectImage(String currentProjectImageContainer) {


        this.currentProjectImageContainer.changeImage(currentProjectImageContainer);
        this.perspectiveDroite.changeImage(currentProjectImageContainer);
        this.perspectiveMilieu.changeImage(currentProjectImageContainer);


    }

    public Perspective getPerspectiveMilieu() {
        return perspectiveMilieu;
    }

    public void setPerspectiveMilieu(Perspective perspectiveMilieu) {
        this.perspectiveMilieu = perspectiveMilieu;
    }

    public Perspective getPerspectiveDroite() {
        return perspectiveDroite;
    }

    public void setPerspectiveDroite(Perspective perspectiveDroite) {
        this.perspectiveDroite = perspectiveDroite;
    }


    public Perspective getPerspective(int perspective){
        if(perspective == CURRENT_PERSPECTIVE_MILIEU)
            return this.getPerspectiveMilieu();
        else if(perspective == CURRENT_PERSPECTIVE_DROITE)
            return this.getPerspectiveDroite();
        else {
            throw new IllegalArgumentException("Invalid perspective value: " + perspective);
        }
    }



    private class Memento implements MementoIF {



        private String imagePath;
        private double xImageMilieu;
        private double yImageMilieu;
        private double xImageDroite;
        private double yImageDroite;
        private double zoomPourcentageImageMilieu;
        private double zoomPourcentageImageDroite;


        /**
         * Cree une copie en copiant les variables
         *
         * @param currentProjectImageContainer
         * @param perspectiveMilieu
         * @param perspectiveDroite
         */

        public Memento(ImageContainer currentProjectImageContainer, Perspective perspectiveMilieu, Perspective perspectiveDroite) {


            this.xImageDroite = perspectiveDroite.getImageView().getX();
            this.yImageDroite = perspectiveDroite.getImageView().getY();
            this.xImageMilieu = perspectiveMilieu.getImageView().getX();
            this.yImageMilieu = perspectiveMilieu.getImageView().getY();
            this.zoomPourcentageImageDroite = perspectiveDroite.getZoomPourcentage();
            this.zoomPourcentageImageMilieu = perspectiveMilieu.getZoomPourcentage();

            this.imagePath = currentProjectImageContainer.getPath();


        }

        public String getImagePath() {
            return imagePath;
        }

        public double getxImageMilieu() {
            return xImageMilieu;
        }

        public double getyImageMilieu() {
            return yImageMilieu;
        }

        public double getxImageDroite() {
            return xImageDroite;
        }

        public double getyImageDroite() {
            return yImageDroite;
        }

        public double getZoomPourcentageImageMilieu() {
            return zoomPourcentageImageMilieu;
        }

        public double getZoomPourcentageImageDroite() {
            return zoomPourcentageImageDroite;
        }
    }



}
