package exemples_demos.maquette;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        CenterPanels root = new CenterPanels();

        PanneauDImage panneau1 = new PanneauDImage("panneau 1");
        PanneauDImage panneau2 = new PanneauDImage("panneau 2");
        PanneauDImage panneau3 = new PanneauDImage("panneau 3");



        // Set layout constraints for the panes
        HBox.setHgrow(panneau1, Priority.ALWAYS);
        HBox.setHgrow(panneau2, Priority.ALWAYS);
        HBox.setHgrow(panneau3, Priority.ALWAYS);


        root.getChildren().addAll(panneau1, panneau2, panneau3);



        Scene mainScene = new Scene(root,1000,600);

        primaryStage.setScene(mainScene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }




    private class CenterPanels extends HBox{


        Background panelsBackground = new Background(new BackgroundFill(Color.YELLOW, null, null));


        CenterPanels(){
            this.setSpacing(10);
            this.setBackground(panelsBackground);
        }

    }


    private class PanneauDImage extends Pane{

        Border paneBorder = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new javafx.scene.layout.BorderWidths(5)));
        Background paneBackground = new Background(new BackgroundFill(Color.RED, null, null));



        public PanneauDImage(String message) {

            this.setWidth(300);
            this.setHeight(200);
            this.setBorder(paneBorder);
            this.setBackground(paneBackground);


        }
    }
}




