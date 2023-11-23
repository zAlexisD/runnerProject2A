import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Static class to display static element (background or number of life for example)
public class StaticThing {
    //attributes
    private double sizeX;
    private double sizeY;
    private ImageView imageView;
    //constructor
    // String filename to point to the Background
    public StaticThing(double sizeX, double sizeY, String fileName) {
        Image backgroundImage = new Image(fileName);
        this.imageView = new ImageView(backgroundImage);
        //set screen size to fit image in it
        imageView.setFitWidth(sizeX);
        imageView.setFitHeight(sizeY);
    }
    //getter
    public ImageView getImageView() {return imageView;}
}
