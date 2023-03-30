package logiciel.vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logiciel.Observateur.Observer;
import logiciel.Observateur.Subject;
import logiciel.modele.ImageContainer;
import logiciel.modele.Perspective;

public class VerticalBoxPrincipal extends VBox implements Observer {


    private HBox panneauDImages;
    private PanneauStatique panneauGauche;
    private PanneauDynamique panneauMilieu;
    private PanneauDynamique panneauDroite;
    private MenuBar barreSelection;
    private Menu file;
    private MenuItem boutonSauvegarde;
    private MenuItem boutonCharger;

    private HBox sectionBas;
    private Button boutonUndo;
    private Button boutonRedo;


    public VerticalBoxPrincipal(Stage primaryStage){

        Background rootBackground = new Background(new BackgroundFill(Color.SILVER, null, null));
        this.setBackground(rootBackground);
        this.setSpacing(10);
        this.setPadding(new Insets(5, 20, 20, 20));

        barreSelection = new MenuBar();
        file = new Menu("File");
        boutonCharger = new MenuItem("Charger");
        boutonSauvegarde = new MenuItem("Sauvegarder");

        file.getItems().addAll(boutonSauvegarde,boutonCharger);
        barreSelection.getMenus().add(file);

        //TODO: METTRE DES VRAIS IMAGES, IMAGEVIEW ET PERSPECTIVES
        panneauGauche = new PanneauStatique(new ImageContainer("banque_images/kitty.jpg"), new ImageView());
        panneauMilieu = new PanneauDynamique(new ImageContainer("banque_images/kitty.jpg"), new Perspective(new ImageView()));
        panneauDroite = new PanneauDynamique(new ImageContainer("banque_images/kitty.jpg"), new Perspective(new ImageView()));

        panneauDImages = new HBox();
        panneauDImages.setSpacing(10);
        panneauDImages.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        panneauDImages.getChildren().addAll(panneauGauche,panneauMilieu,panneauDroite);

        sectionBas = new HBox();

        sectionBas.setSpacing(20);

        boutonUndo = new Button("Undo");
        boutonRedo = new Button("Redo");

        sectionBas.getChildren().addAll(boutonUndo, boutonRedo);

        this.getChildren().addAll(barreSelection, panneauDImages, sectionBas);


        Scene mainScene = new Scene(this, 1500, 800);

        primaryStage.setScene(mainScene);
        primaryStage.sizeToScene();
        primaryStage.show();



    }




    public HBox getPanneauDImages() {
        return panneauDImages;
    }

    public PanneauStatique getPanneauGauche() {
        return panneauGauche;
    }

    public PanneauDynamique getPanneauMilieu() {
        return panneauMilieu;
    }

    public PanneauDynamique getPanneauDroite() {
        return panneauDroite;
    }

    public MenuBar getBarreSelection() {
        return barreSelection;
    }

    public MenuItem getBoutonSauvegarde() {
        return boutonSauvegarde;
    }

    public MenuItem getBoutonCharger() {
        return boutonCharger;
    }

    public HBox getSectionBas() {
        return sectionBas;
    }

    public Button getBoutonUndo() {
        return boutonUndo;
    }

    public Button getBoutonRedo() {
        return boutonRedo;
    }

    @Override
    public void update(Subject s) {

    }
}
