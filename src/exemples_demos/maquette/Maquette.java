package exemples_demos.maquette;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;


public class Maquette extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Mock de PerspectivePro");


        VBox root = new VBox();

        Background rootBackground = new Background(new BackgroundFill(Color.SILVER, null, null));
        root.setBackground(rootBackground);

        root.setSpacing(10);

        root.setPadding(new Insets(5, 20, 20, 20));


        MenuBar sectionHaut = new MenuBar();

        Menu file = new Menu("File");
        Menu sauvegarder = new Menu("Sauvegarder");

        sectionHaut.getMenus().addAll(file ,sauvegarder);





        CenterPanels centerPanels = new CenterPanels();
        PanneauDImage panneau1 = new PanneauDImage("panneau 1");
        PanneauDImage panneau2 = new PanneauDImage("panneau 2");
        PanneauDImage panneau3 = new PanneauDImage("panneau 3");



        HBox sectionBas = new HBox();

        sectionBas.setSpacing(20);

        sectionBas.getChildren().add(new Button("Undo"));
        sectionBas.getChildren().add(new Button("Redo"));
        sectionBas.getChildren().add(new Button("Sauvegarder"));

        centerPanels.getChildren().addAll(panneau1, panneau2, panneau3);

        root.getChildren().add(sectionHaut);
        root.getChildren().add(centerPanels);
        root.getChildren().add(sectionBas);


        Scene mainScene = new Scene(root,1500,800);

        primaryStage.setScene(mainScene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }




    private class CenterPanels extends HBox{
        Background panelsBackground = new Background(new BackgroundFill(Color.WHITESMOKE, null, null));

        CenterPanels(){
            this.setSpacing(10);
            this.setBackground(panelsBackground);
        }

    }


    private class PanneauDImage extends Pane{

        Border paneBorder = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new javafx.scene.layout.BorderWidths(5)));
        Background paneBackground = new Background(new BackgroundFill(Color.WHITESMOKE, null, null));


        ImageView currentImageView = new ImageView("banque_images/kitty.jpg");




        public PanneauDImage(String message) {


            this.setPrefSize(600,800);
            this.setMaxSize(600,800);

            this.setBorder(paneBorder);
            this.setBackground(paneBackground);
            this.getChildren().add(currentImageView);




            AtomicReference<Double> ecartH = new AtomicReference<>((double) 0);
            AtomicReference<Double> ecartV = new AtomicReference<>((double) 0);


            currentImageView.setOnMousePressed(event -> {
//                double ecartX =currentImageView.getX()-event.getX();
//                double ecartY =currentImageView.getY()-event.getY();
                ecartH.set(currentImageView.getX()-event.getX());
                ecartV.set(currentImageView.getY()-event.getY());


            });

            currentImageView.setOnMouseDragged(e -> {
                double positionX = e.getX()+ecartH.get();
                double positionY = e.getY()+ecartV.get();
                double ecartX =currentImageView.getX()-e.getX();
                double ecartY =currentImageView.getY()-e.getY();
//                System.out.println("ecartH: "+ecartH.get());
//                System.out.println("ecartV: "+ecartV.get());
//                System.out.println("eX: "+e.getX());
//                System.out.println("eY: "+e.getY());
                System.out.println("X: "+ positionX );
                System.out.println("Y: "+ positionY);
//                System.out.println("-------------------fin");
                if(positionX >= 0 ){
                    currentImageView.setX(positionX);
                }else{

                    ecartH.set(ecartX);
                }


                if(positionY>=0){
                    currentImageView.setY(positionY);
                }else{
                    ecartV.set(ecartY);
                }

//                currentImageView.setTranslateX(positionX);
//                currentImageView.setTranslateY(positionY);

            });


        }




    }
}