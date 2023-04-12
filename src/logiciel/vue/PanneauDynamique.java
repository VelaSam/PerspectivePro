package logiciel.vue;
import javafx.scene.layout.Border;
import logiciel.observateur.Observer;
import logiciel.observateur.Subject;
import logiciel.modele.Perspective;


/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: PanneauDynamique.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-02
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-03-23 getters et setters
 2023-04-02 implementation


 *******************************************************/

public class PanneauDynamique extends AbstractPanneau implements Observer {


    private Border paneBackgound;
    private Perspective perspective;


    public PanneauDynamique( Perspective perspective) {
        super();
        this.perspective = perspective;
        super.getChildren().add(this.perspective.getImageView());


    }



    public Perspective getPerspective() {
        return perspective;
    }

    public void setPerspective(Perspective perspective) {
        this.perspective = perspective;
    }

    @Override
    public void update(Subject s) {


    }
}
