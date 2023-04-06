package logiciel.modele;

import javafx.scene.image.Image;
import logiciel.controleur.GestionnaireCommande;
import logiciel.memento.MementoIF;
import logiciel.observateur.Observer;
import logiciel.observateur.Subject;
import sun.net.www.content.text.Generic;

import java.util.ArrayList;

public class CurrentProjectState extends Subject {

    public static final int CURRENT_PERSPECTIVE_MILIEU = 0;
    public static final int CURRENT_PERSPECTIVE_DROITE = 1;

    private ImageContainer currentProjectImageContainer;
    private Perspective perspectiveMilieu;
    private Perspective perspectiveDroite;
    private int currentPerspective;





    public CurrentProjectState(ImageContainer currentProjectImageContainer, Perspective perspectiveMilieu, Perspective perspectiveDroite) {
        this.currentProjectImageContainer = currentProjectImageContainer;
        this.perspectiveMilieu = perspectiveMilieu;
        this.perspectiveDroite = perspectiveDroite;
        this.currentPerspective = 0;



    }

    public MementoIF save(){
       return new Memento(currentProjectImageContainer, perspectiveMilieu, perspectiveDroite);
    }

    public void restore(){

        GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();


        Memento mementoToPop = (Memento) gestionnaireCommande.undo();
        if (mementoToPop != null){
            this.perspectiveDroite.getImageView().setImage(new Image("file:\\"+mementoToPop.getImagePath()));

            this.perspectiveMilieu.getImageView().setImage(new Image("file:\\"+mementoToPop.getImagePath()));

            this.currentProjectImageContainer.getImageView().setImage(new Image("file:\\"+mementoToPop.getImagePath()));

            this.perspectiveDroite.getImageView().setX(mementoToPop.getxImageDroite());
            this.perspectiveDroite.getImageView().setY(mementoToPop.getyImageDroite());
            this.perspectiveDroite.setZoomPourcentage(mementoToPop.getZoomPourcentageImageDroite());


            this.perspectiveMilieu.getImageView().setX(mementoToPop.getxImageMilieu());
            this.perspectiveMilieu.getImageView().setY(mementoToPop.getyImageMilieu());
            this.perspectiveMilieu.setZoomPourcentage(mementoToPop.getZoomPourcentageImageMilieu());

            this.perspectiveMilieu.notifyObservers();
            this.perspectiveDroite.notifyObservers();
            this.currentProjectImageContainer.notifyObservers();
        }

    }

    public void getBack(){

        GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

        Memento mementoToPop = (Memento) gestionnaireCommande.redo();
        if (mementoToPop != null){
            this.perspectiveDroite.getImageView().setImage(new Image("file:\\"+mementoToPop.getImagePath()));

            this.perspectiveMilieu.getImageView().setImage(new Image("file:\\"+mementoToPop.getImagePath()));

            this.currentProjectImageContainer.getImageView().setImage(new Image("file:\\"+mementoToPop.getImagePath()));

            this.perspectiveDroite.getImageView().setX(mementoToPop.getxImageDroite());
            this.perspectiveDroite.getImageView().setY(mementoToPop.getyImageDroite());
            this.perspectiveDroite.setZoomPourcentage(mementoToPop.getZoomPourcentageImageDroite());


            this.perspectiveMilieu.getImageView().setX(mementoToPop.getxImageMilieu());
            this.perspectiveMilieu.getImageView().setY(mementoToPop.getyImageMilieu());
            this.perspectiveMilieu.setZoomPourcentage(mementoToPop.getZoomPourcentageImageMilieu());

            this.perspectiveMilieu.notifyObservers();
            this.perspectiveDroite.notifyObservers();
            this.currentProjectImageContainer.notifyObservers();
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
