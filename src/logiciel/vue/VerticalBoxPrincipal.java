package logiciel.vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logiciel.observateur.Observer;
import logiciel.observateur.Subject;


/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: PanneauDynamique.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-07
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-04-06 debut dimplmentation
 2023-04-07 changements types de boutons


 *******************************************************/

public class VerticalBoxPrincipal extends VBox implements Observer {


    private HBox panneauDImages;
    private PanneauStatique panneauGauche;
    private PanneauDynamique panneauMilieu;
    private PanneauDynamique panneauDroite;
    private MenuBar barreSelection;
    private Menu file;
    private MenuItem boutonSauvegarde;
    private MenuItem boutonChargerImage;
    private MenuItem boutonChargerProjet;

    private HBox sectionBas;
    private Button boutonUndo;
    private Button boutonRedo;


    public VerticalBoxPrincipal(Stage primaryStage,PanneauStatique ps, PanneauDynamique pdMilieu, PanneauDynamique pdDroite){

        Background rootBackground = new Background(new BackgroundFill(Color.SILVER, null, null));
        this.setBackground(rootBackground);
        this.setSpacing(10);
        this.setPadding(new Insets(5, 20, 20, 20));

        barreSelection = new MenuBar();
        file = new Menu("File");
        boutonChargerImage = new MenuItem("Charger Image");
        boutonSauvegarde = new MenuItem("Sauvegarder");
        boutonChargerProjet = new MenuItem("Charger Projet");

        file.getItems().addAll(boutonSauvegarde, boutonChargerImage, boutonChargerProjet);
        barreSelection.getMenus().add(file);


        panneauGauche = ps;
        panneauMilieu = pdMilieu;
        panneauDroite = pdDroite;

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

    public MenuItem getBoutonChargerImage() {
        return boutonChargerImage;
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

    public MenuItem getBoutonChargerProjet() {
        return boutonChargerProjet;
    }
}
