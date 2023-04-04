package logiciel.modele;

import logiciel.memento.MementoIF;
import logiciel.observateur.Subject;

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

    public MementoIF save() throws CloneNotSupportedException{
       return new Memento(currentProjectImageContainer, perspectiveMilieu, perspectiveDroite);
    }

    public void restore(){
        //TODO: restore method
        /* L'idée est que Controleur vas execute la CommandeUndo qui vas appeler la méthode présente restore()
           ((MementoIF)GestionnaireCommande.getInstance().undo()).getState(this);
                 1)La méthode undo() renvoie le mémento qui doit être utiliser pour restorer l'instance
                      (peut être pas besoin de cast MementoIF)
                 2)Notre implémentation de MementoIF as la méthode getState(this) qui prend le CurrentProjectState
             3)À l'intérieur du mémento il vas changer les valeurs cu CPS avec la référence this

         */
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

        ImageContainer currentProjectImageContainer;
        Perspective perspectiveMilieu;
        Perspective perspectiveDroite;

        public Memento(ImageContainer currentProjectImageContainer, Perspective perspectiveMilieu, Perspective perspectiveDroite) {

            this.currentProjectImageContainer = currentProjectImageContainer.clone();
            this.perspectiveMilieu = perspectiveMilieu.clone();
            this.perspectiveDroite = perspectiveDroite.clone();

            

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
    }



}
