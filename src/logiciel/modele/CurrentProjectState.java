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
            this.perspectiveDroite.getImageView().setImage(new Image("file:/"+System.getProperty("user.dir")+mementoToPop.getImagePath()));
            System.out.println(mementoToPop.getImagePath());
            this.perspectiveMilieu.getImageView().setImage(new Image("file:/"+System.getProperty("user.dir")+mementoToPop.getImagePath()));

            this.currentProjectImageContainer.getImageView().setImage(new Image("file:/"+System.getProperty("user.dir")+mementoToPop.getImagePath()));

            this.perspectiveDroite.getImageView().setX(mementoToPop.getMementoPerspectiveDroite().getImageView().getX());
            this.perspectiveDroite.getImageView().setY(mementoToPop.getMementoPerspectiveDroite().getImageView().getY());
            this.perspectiveDroite.setZoomPourcentage(mementoToPop.zoomPourcentageImageDroite);


            this.perspectiveMilieu.getImageView().setX(mementoToPop.getMementoPerspectiveMilieu().getImageView().getX());
            this.perspectiveMilieu.getImageView().setY(mementoToPop.getMementoPerspectiveMilieu().getImageView().getY());
            this.perspectiveMilieu.setZoomPourcentage(mementoToPop.zoomPourcentageImageMilieu);

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

        private ImageContainer currentProjectImageContainer;
        private Perspective perspectiveMilieu;
        private Perspective perspectiveDroite;

        private String imagePath;
        private double xImageMilieu;
        private double yImageMilieu;
        private double xImageDroite;
        private double yImageDroite;
        private double zoomPourcentageImageMilieu;
        private double zoomPourcentageImageDroite;


        public Memento(ImageContainer currentProjectImageContainer, Perspective perspectiveMilieu, Perspective perspectiveDroite) {

            this.currentProjectImageContainer = currentProjectImageContainer.clone();
            this.perspectiveMilieu = perspectiveMilieu.clone();
            this.perspectiveDroite = perspectiveDroite.clone();

            this.xImageDroite = perspectiveDroite.getImageView().getX();
            this.yImageDroite = perspectiveDroite.getImageView().getY();
            this.xImageMilieu = perspectiveMilieu.getImageView().getX();
            this.yImageMilieu = perspectiveMilieu.getImageView().getY();
            this.zoomPourcentageImageDroite = perspectiveDroite.getZoomPourcentage();
            this.zoomPourcentageImageMilieu = perspectiveMilieu.getZoomPourcentage();


        }


        public ImageContainer getMementoProjectImage() {
            return currentProjectImageContainer;
        }

        public Perspective getMementoPerspectiveMilieu() {
            return perspectiveMilieu;
        }

        public Perspective getMementoPerspectiveDroite() {
            return perspectiveDroite;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }
    }



}
