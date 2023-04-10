package logiciel.vue;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
