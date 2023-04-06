package logiciel.controleur;

import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import logiciel.commande.*;
import logiciel.memento.MementoIF;
import logiciel.modele.CurrentProjectState;
import logiciel.vue.VerticalBoxPrincipal;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

public class Controleur {

    private VerticalBoxPrincipal vbp;
    private Commande commande;


    private AtomicReference<Double> ecartHM = new AtomicReference<>((double) 0);
    private AtomicReference<Double> ecartVM = new AtomicReference<>((double) 0);
    private AtomicReference<Double> ecartHD = new AtomicReference<>((double) 0);
    private AtomicReference<Double> ecartVD = new AtomicReference<>((double) 0);

    public Controleur(VerticalBoxPrincipal vbp){
        this.vbp = vbp;
        this.initActionButtons();

    }
    public void executeCommand(){

        if(!(commande instanceof CommandUndo) && !(commande instanceof CommandRedo)){
            emptyRedoStack();
        }
        commande.execute();
    }

    public void initSauvegarde(){
        //TODO: cette methode
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Commande getCommande() {
        return commande;
    }

    public VerticalBoxPrincipal getVbp() {
        return vbp;
    }

    private void initActionButtons(){
    // Initialiser tout les actions des boutons de VBP
        vbp.getBoutonChargerImage().setOnAction(e ->{
            this.setCommande(new CommandeCharger());
            this.executeCommand();
        });

        vbp.getPanneauMilieu().getPerspective().getImageView().setOnMousePressed(e->{
            GestionnaireCommande gc = GestionnaireCommande.getInstance();
            MementoIF memento = gc.getCps().save();
            gc.getPileDeCommande().add(memento);

            ecartHM.set(vbp.getPanneauMilieu().getPerspective().getImageView().getX()-e.getX());
            ecartVM.set(vbp.getPanneauMilieu().getPerspective().getImageView().getY()-e.getY());
        });


        vbp.getPanneauDroite().getPerspective().getImageView().setOnMousePressed(e->{
            GestionnaireCommande gc = GestionnaireCommande.getInstance();
            MementoIF memento = gc.getCps().save();
            gc.getPileDeCommande().add(memento);

            ecartHD.set(vbp.getPanneauDroite().getPerspective().getImageView().getX()-e.getX());
            ecartVD.set(vbp.getPanneauDroite().getPerspective().getImageView().getY()-e.getY());
        });

        vbp.getPanneauMilieu().getPerspective().getImageView().setOnMouseDragged(e->{
            this.setCommande(new CommandTranslate(e, vbp.getPanneauMilieu().getPerspective().getImageView(),ecartHM.get(), ecartVM.get()));
            this.executeCommand();
        });

        vbp.getPanneauDroite().getPerspective().getImageView().setOnMouseDragged(e->{
            this.setCommande(new CommandTranslate(e, vbp.getPanneauDroite().getPerspective().getImageView(),ecartHD.get(),ecartVD.get()));
            this.executeCommand();
        });

        vbp.getPanneauMilieu().getPerspective().getImageView().setOnScroll(e ->{

            GestionnaireCommande gc = GestionnaireCommande.getInstance();
            MementoIF memento = gc.getCps().save();
            gc.getPileDeCommande().add(memento);
            //zoom
            if(e.getDeltaY() > 0){
                this.setCommande(new CommandZoomIn(e, CurrentProjectState.CURRENT_PERSPECTIVE_MILIEU));
                this.executeCommand();

                //dezoom
            }else if(e.getDeltaY() < 0){
                this.setCommande(new CommandZoomOut(e, CurrentProjectState.CURRENT_PERSPECTIVE_MILIEU));
                this.executeCommand();
            }
        });

        vbp.getPanneauDroite().getPerspective().getImageView().setOnScroll(e ->{

            GestionnaireCommande gc = GestionnaireCommande.getInstance();
            MementoIF memento = gc.getCps().save();
            gc.getPileDeCommande().add(memento);
            //zoom
            if(e.getDeltaY() > 0){
                this.setCommande(new CommandZoomIn(e, CurrentProjectState.CURRENT_PERSPECTIVE_DROITE));
                this.executeCommand();

                //dezoom
            }else if(e.getDeltaY() < 0){
                this.setCommande(new CommandZoomOut(e, CurrentProjectState.CURRENT_PERSPECTIVE_DROITE));
                this.executeCommand();
            }
        });

        vbp.getBoutonUndo().setOnAction(e ->{
            GestionnaireCommande gc = GestionnaireCommande.getInstance();
            MementoIF memento = gc.getCps().save();
            gc.getPileDeUndo().add(memento);

            this.setCommande(new CommandUndo());
            this.executeCommand();
        });

        vbp.getBoutonRedo().setOnAction(e -> {
            GestionnaireCommande gc = GestionnaireCommande.getInstance();
            if(!gc.getPileDeUndo().empty()){
                MementoIF memento = gc.getCps().save();
                gc.getPileDeCommande().add(memento);
            }


            this.setCommande(new CommandRedo());
            this.executeCommand();
        });

        vbp.getBoutonSauvegarde().setOnAction(e ->{
            GestionnaireCommande gc = GestionnaireCommande.getInstance();
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Save Directory");

            //Ajustment of perspectives before serialisation
            gc.getCps().getPerspectiveMilieu().setPositionX(gc.getCps().getPerspectiveMilieu().getImageView().getX());
            gc.getCps().getPerspectiveMilieu().setPositionY(gc.getCps().getPerspectiveMilieu().getImageView().getY());

            gc.getCps().getPerspectiveDroite().setPositionX(gc.getCps().getPerspectiveDroite().getImageView().getX());
            gc.getCps().getPerspectiveDroite().setPositionY(gc.getCps().getPerspectiveDroite().getImageView().getY());


            // Show only directories
            directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));

            // Show the file chooser dialog
            File selectedDirectory = directoryChooser.showDialog(new Stage());
            try {
                FileOutputStream fileOut = new FileOutputStream(selectedDirectory.getPath()+"\\SauvegardeProjet.ser");

                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(gc.getCps());
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }

        });

        vbp.getBoutonChargerProjet().setOnAction(event -> {
            GestionnaireCommande gc = GestionnaireCommande.getInstance();
            CurrentProjectState cps;
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");

            // Show only directories
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));


            // Show the file chooser dialog
            File selectedFile = fileChooser.showOpenDialog(new Stage());
            try {
                FileInputStream fileIn = new FileInputStream(selectedFile);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                cps = (CurrentProjectState) in.readObject();

                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
                return;
            }

            if(cps != null){
                //PerspectiveGauche
                gc.getCps().getCurrentProjectImage().getImageView().setImage(new Image("file:\\"+cps.getCurrentProjectImage().getPath()));
                //PerspectiveMilieu
                gc.getCps().getPerspectiveMilieu().getImageView().setImage(new Image("file:\\"+cps.getCurrentProjectImage().getPath()));
                gc.getCps().getPerspectiveMilieu().getImageView().setX(cps.getPerspectiveMilieu().getPositionX());
                gc.getCps().getPerspectiveMilieu().getImageView().setY(cps.getPerspectiveMilieu().getPositionY());
                gc.getCps().getPerspectiveMilieu().setZoomPourcentage(cps.getPerspectiveMilieu().getZoomPourcentage());
                //PerspectiveDroite
                gc.getCps().getPerspectiveDroite().getImageView().setImage(new Image("file:\\"+cps.getCurrentProjectImage().getPath()));
                gc.getCps().getPerspectiveDroite().getImageView().setX(cps.getPerspectiveDroite().getPositionX());
                gc.getCps().getPerspectiveDroite().getImageView().setY(cps.getPerspectiveDroite().getPositionY());
                gc.getCps().getPerspectiveDroite().setZoomPourcentage(cps.getPerspectiveDroite().getZoomPourcentage());
            }


        });

    }


    private void emptyRedoStack(){
        GestionnaireCommande.getInstance().getPileDeUndo().clear();

    }

}
