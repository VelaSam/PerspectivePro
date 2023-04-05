package logiciel.vue;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import logiciel.observateur.Observer;
import logiciel.observateur.Subject;
import logiciel.controleur.GestionnaireCommande;
import logiciel.modele.CurrentProjectState;
import logiciel.modele.ImageContainer;
import logiciel.modele.Perspective;

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

//        super.getChildren().clear();
        
//        this.perspective.getImageView().setScaleX(this.perspective.getZoomPourcentage());
//        this.perspective.getImageView().setScaleY(this.perspective.getZoomPourcentage());

//        super.getChildren().add(this.perspective.getImageView());
        System.out.println("Children added: "+this.perspective.getImageView().getX());

    }
}
