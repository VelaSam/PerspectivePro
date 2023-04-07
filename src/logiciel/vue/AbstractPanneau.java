package logiciel.vue;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class AbstractPanneau extends BorderPane{

    Border paneBorder = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new javafx.scene.layout.BorderWidths(5)));
    Background paneBackground = new Background(new BackgroundFill(Color.WHITESMOKE, null, null));



    protected AbstractPanneau() {

        this.setPrefSize(600,800);
        this.setMaxSize(600,800);

        this.setBorder(paneBorder);
        this.setBackground(paneBackground);


    }
}
