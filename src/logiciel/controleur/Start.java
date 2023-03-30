package logiciel.controleur;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
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




    }

    public VerticalBoxPrincipal getVerticalBoxPrincipal() {
        return verticalBoxPrincipal;
    }
}
