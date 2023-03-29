package logiciel.modele;

public class Image extends javafx.scene.image.Image implements Cloneable {

    private String path;

    public Image(String path) {

        super(path);

        this.path = path;
    }

    public Image clone() throws CloneNotSupportedException {
        return (Image) super.clone();
    }

}
