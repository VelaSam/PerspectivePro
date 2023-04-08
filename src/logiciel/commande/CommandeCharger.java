package logiciel.commande;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import logiciel.controleur.GestionnaireCommande;
import logiciel.memento.MementoIF;
import logiciel.modele.ImageContainer;

import java.io.File;
import java.net.MalformedURLException;

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
