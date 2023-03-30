package logiciel.controleur;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import logiciel.modele.CurrentProjectState;
import logiciel.vue.VerticalBoxPrincipal;

public class Start extends Application {

    private VerticalBoxPrincipal verticalBoxPrincipal;
    private Controleur controler;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("PerspectivePro");
        primaryStage.getIcons().add(new Image("file:icon.png"));

        verticalBoxPrincipal = new VerticalBoxPrincipal(primaryStage);
        controler = new Controleur(verticalBoxPrincipal);

        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        gc.setCps(new CurrentProjectState(
                verticalBoxPrincipal.getPanneauGauche().getImage(),
                verticalBoxPrincipal.getPanneauMilieu().getPerspective(),
                verticalBoxPrincipal.getPanneauDroite().getPerspective()
        ));

        gc.getCps().attachObserver(verticalBoxPrincipal.getPanneauDroite());
        gc.getCps().attachObserver(verticalBoxPrincipal.getPanneauMilieu());




    }

    public VerticalBoxPrincipal getVerticalBoxPrincipal() {
        return verticalBoxPrincipal;
    }
}
