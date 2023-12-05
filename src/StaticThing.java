import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Static class to display static element (background or number of life for example)
public class StaticThing {
    // Attributes
    private double x;
    private double y;
    private double sizeX;
    private double sizeY;
    private double displayWidth = 600;
    private ImageView imageView;
    // Constructor
    // String filename to point to the Background
    public StaticThing(double sizeX, double sizeY, double x, double y, String fileName) {
        this.x = x;
        this.y = y;
        Image backgroundImage = new Image(fileName);
        this.imageView = new ImageView(backgroundImage);
        // Set screen size to fit image in it
        imageView.setFitWidth(sizeX);
        imageView.setFitHeight(sizeY);
        // Set screen position
        imageView.setX(x);
        imageView.setY(y);
    }
    // Getter
    public ImageView getImageView() {return imageView;}

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Set x position method
    public void setX(double x){
        this.x = x;
        imageView.setX(x);
    }
    public double getDisplayWidth() {
        return displayWidth;
    }
}
