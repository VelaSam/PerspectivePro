package logiciel.vue;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;


/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: AbstractPanneau.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-05
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-03-24 Changements mineurs
 2023-04-05 Finalisation de la classe


 *******************************************************/

public abstract class AbstractPanneau extends BorderPane{
    public final static int WIDTH = 480;
    public final static int HEIGHT = 700;

    Border paneBorder = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new javafx.scene.layout.BorderWidths(5)));
    Background paneBackground = new Background(new BackgroundFill(Color.WHITESMOKE, null, null));



    protected AbstractPanneau() {

        this.setPrefSize(WIDTH,HEIGHT);
        this.setMaxSize(WIDTH,HEIGHT);
        this.setMinSize(WIDTH,HEIGHT);


        this.setBorder(paneBorder);
        this.setBackground(paneBackground);

    }
}
