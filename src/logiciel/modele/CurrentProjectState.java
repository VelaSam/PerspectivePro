package logiciel.modele;

import logiciel.memento.Memento;

public class CurrentProjectState {

    public final int CURRENTPERSPECTIVEMILIEU = 0;
    public final int CURRENTPERSPECTIVEDROIT = 1;
    private Image currentProjectImage;
    private Perspective perspectiveMilieu;
    private Perspective perspectiveDroite;
    private int currentPerspective;


    public CurrentProjectState(Image currentProjectImage, Perspective perspectiveMilieu, Perspective perspectiveDroite) {
        this.currentProjectImage = currentProjectImage;
        this.perspectiveMilieu = perspectiveMilieu;
        this.perspectiveDroite = perspectiveDroite;
        this.currentPerspective = 0;
    }

    public Memento save() throws CloneNotSupportedException{
       return new Memento(currentProjectImage, perspectiveMilieu, perspectiveDroite);
    }

    public void restore(){
        //TODO: restore method
        /* L'idée est que Controleur vas execute la CommandeUndo qui vas appeler la méthode présente restore()
           ((Memento)GestionnaireCommande.getInstance().undo()).getState(this);
                 1)La méthode undo() renvoie le mémento qui doit être utiliser pour restorer l'instance
                      (peut être pas besoin de cast Memento)
                 2)Notre implémentation de Memento as la méthode getState(this) qui prend le CurrentProjectState
             3)À l'intérieur du mémento il vas changer les valeurs cu CPS avec la référence this

         */
    }


    public Image getCurrentProjectImage() {
        return currentProjectImage;
    }

    public void setCurrentProjectImage(Image currentProjectImage) {
        this.currentProjectImage = currentProjectImage;
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
}
