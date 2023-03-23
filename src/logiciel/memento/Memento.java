package logiciel.memento;

import logiciel.modele.CurrentProjectState;
import logiciel.modele.Image;
import logiciel.modele.Perspective;

public class Memento {


    CurrentProjectState cps;

    public Memento(CurrentProjectState cps) {
        this.cps = cps;
    }

    public Memento(Image currentProjectImage, Perspective perspectiveMilieu, Perspective perspectiveDroite){

        //TODO: GROS PROBLEME MEMENTO ONT TT LES MEME REFERENCE. ON VEUT PASSER PAR COPIE ET NON PAS REFERENCE

        this.cps = new CurrentProjectState(currentProjectImage, perspectiveDroite, perspectiveMilieu);

    }

    public CurrentProjectState getCps() {
        return cps;
    }

    public void setCps(CurrentProjectState cps) {
        this.cps = cps;
    }

    public CurrentProjectState getState(){

        return this.cps;

    }
}


