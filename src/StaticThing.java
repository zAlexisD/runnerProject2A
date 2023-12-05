import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Static class to display static element (background or number of life for example)
public class StaticThing {
    // Attributes
    private double sizeX;
    private double sizeY;
    private ImageView imageView;
    // Constructor
    // String filename to point to the Background
    public StaticThing(double sizeX, double sizeY, String fileName) {
        Image backgroundImage = new Image(fileName);
        this.imageView = new ImageView(backgroundImage);
        // Set screen size to fit image in it
        imageView.setFitWidth(sizeX);
        imageView.setFitHeight(sizeY);
    }
    // Getter
    public ImageView getImageView() {return imageView;}
}
