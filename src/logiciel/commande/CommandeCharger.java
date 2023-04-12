package logiciel.commande;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import logiciel.controleur.GestionnaireCommande;
import logiciel.memento.MementoIF;
import logiciel.modele.ImageContainer;

import java.io.File;
import java.net.MalformedURLException;


/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: Observateur.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-04
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-04-4 Implementation de la classe
 *******************************************************/

public class CommandeCharger implements Commande{
    @Override
    public void execute() {

        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        MementoIF memento = gc.getCps().save();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");

        // Show only directories
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.jpg","*.pnj"));

        // Show the file chooser dialog
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            System.out.println(selectedFile.getAbsolutePath());



            gc.getCps().getCurrentProjectImage();
            gc.getCps().getCurrentProjectImage().getImageView().setImage(new Image("file:\\"+selectedFile.getAbsolutePath()));
            gc.getCps().getPerspectiveMilieu().getImageView().setImage(new Image("file:\\"+selectedFile.getAbsolutePath()));
            gc.getCps().getPerspectiveDroite().getImageView().setImage(new Image("file:\\"+selectedFile.getAbsolutePath()));



        } else{
            System.out.println("Pas de fichier sélectionner");
        }
    }
}
