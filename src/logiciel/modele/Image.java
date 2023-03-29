package logiciel.modele;

public class Image extends javafx.scene.image.Image {

    private String path;

    public Image(String path) {

        super(path);

        this.path = path;
    }

    public Image clone() {
        return new Image(this.path);
    }

}
