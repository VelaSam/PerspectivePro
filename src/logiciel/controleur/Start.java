package logiciel.controleur;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logiciel.modele.CurrentProjectState;
import logiciel.modele.ImageContainer;
import logiciel.modele.Perspective;
import logiciel.vue.PanneauDynamique;
import logiciel.vue.PanneauStatique;
import logiciel.vue.VerticalBoxPrincipal;

import java.io.File;

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


        System.out.println(System.getProperty("user.dir")+"\\src\\banque_images\\kitty.jpg");
        ImageContainer imageCIdle = new ImageContainer(System.getProperty("user.dir")+"\\src\\banque_images\\kitty.jpg");

        ImageView imageVMilieu = new ImageView("\\banque_images\\kitty.jpg");
        ImageView imageVDroite = new ImageView("\\banque_images\\kitty.jpg");

        Perspective perspectiveMilieu = new Perspective(imageVMilieu);
        Perspective perspectiveDroite = new Perspective(imageVDroite);

        PanneauStatique panneauIdle = new PanneauStatique(imageCIdle);
        PanneauDynamique panneauMilieu = new PanneauDynamique(perspectiveMilieu);
        PanneauDynamique panneauDroite = new PanneauDynamique(perspectiveDroite);

        imageCIdle.getImageView().setX(110);
        imageCIdle.getImageView().setY(200);





        verticalBoxPrincipal = new VerticalBoxPrincipal(primaryStage, panneauIdle, panneauMilieu, panneauDroite);
        controler = new Controleur(verticalBoxPrincipal);

        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        gc.setCps(new CurrentProjectState(
                verticalBoxPrincipal.getPanneauGauche().getImage(),
                verticalBoxPrincipal.getPanneauMilieu().getPerspective(),
                verticalBoxPrincipal.getPanneauDroite().getPerspective()
        ));

        gc.setVerticalBoxPrincipal(verticalBoxPrincipal);

        imageCIdle.attachObserver(panneauIdle);
        perspectiveDroite.attachObserver(panneauDroite);
        perspectiveMilieu.attachObserver(panneauMilieu);


    }

    public VerticalBoxPrincipal getVerticalBoxPrincipal() {
        return verticalBoxPrincipal;
    }

    private class ImageView extends javafx.scene.image.ImageView{

        public ImageView(String path){

            this.setImage(new Image(path));
            this.setX(110);
            this.setY(200);
        }
    }
}
