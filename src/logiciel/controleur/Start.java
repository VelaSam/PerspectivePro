package logiciel.controleur;

import javafx.application.Application;
import javafx.stage.Stage;
import logiciel.vue.VerticalBoxPrincipal;

public class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Mock de PerspectivePro");

        VerticalBoxPrincipal verticalBoxPrincipal = new VerticalBoxPrincipal(primaryStage);



    }
}
