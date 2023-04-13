package logiciel.commande;

import javafx.scene.input.MouseEvent;
import logiciel.controleur.GestionnaireCommande;
import logiciel.modele.Perspective;

/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: CommandTranslate.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-04
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-04-04 Implementation de la classe
 *******************************************************/

public class CommandTranslate implements Commande {

    private Perspective perspective;
    private MouseEvent event;
    private double ecartH;
    private double ecartV;

    public CommandTranslate(MouseEvent event, Perspective perspective, double ecartH, double ecartV) {
        this.perspective = perspective;
        this.event = event;
        this.ecartH = ecartH;
        this.ecartV = ecartV;
    }

    /**
     * Commande qui permet de glisser limage sur sa perspective respective
     */
    @Override
    public void execute() {
        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        double positionX = event.getX() + ecartH;
        double positionY = event.getY() + ecartV;
        perspective.setPositionX(positionX);
        perspective.setPositionY(positionY);


    }
}
