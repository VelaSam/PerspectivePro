package exemples_demos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class ExemplePanneauMilieuEtDroite extends Application {

    private static final String[] IMAGE_FILENAMES = {
            "banque_images/flower.png",
            "banque_images/foot.png",
            "banque_images/hahalol.jpg",
            "banque_images/kitty.jpg",
            "banque_images/pepe.png",
            "banque_images/scenery.jpg"
    };

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();

        ImageView[] imageViews = new ImageView[IMAGE_FILENAMES.length];
        for (int i = 0; i < IMAGE_FILENAMES.length; i++) {
            imageViews[i] = new ImageView(IMAGE_FILENAMES[i]);
        }

        StackPane stackPane = new StackPane();

        AtomicReference<ImageView> currentImageView = new AtomicReference<>(imageViews[0]);

        Button[] buttons = new Button[IMAGE_FILENAMES.length];
        for (int i = 0; i < IMAGE_FILENAMES.length; i++) {
            buttons[i] = new Button("image " + (i + 1));
            final int index = i;
            buttons[i].setOnAction(e -> {
                currentImageView.set(imageViews[index]);
                vBox.getChildren().set(0, new StackPane(currentImageView.get()));
            });
        }

        Scene scene = new Scene(vBox, 1800 , 900);

        AtomicReference<Double> ecartH = new AtomicReference<>((double) 0);
        AtomicReference<Double> ecartV = new AtomicReference<>((double) 0);

        currentImageView.get().setOnMousePressed(event -> {
            ecartH.set(currentImageView.get().getX() - event.getX());
            ecartV.set(currentImageView.get().getY() - event.getY());
        });
        currentImageView.get().setOnMouseDragged(event -> {
            currentImageView.get().setX(event.getX()+ecartH.get());
            currentImageView.get().setY(event.getY()+ecartV.get());
            currentImageView.get().setTranslateX(currentImageView.get().getX());
            currentImageView.get().setTranslateY(currentImageView.get().getY());
        });

        vBox.getChildren().add(currentImageView.get());
        HBox hBox = new HBox(buttons);
        vBox.getChildren().add(hBox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
