import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    //take 3 attributes : two int for the screen size and a camera
    private double gameSceneLength;
    private double gameSceneHeight;
    private Camera gameCamera;
    private StaticThing backgroundLeft;
    private StaticThing backgroundRight;
    //StaticThing variables
    private double backgroundLenght = 600;
    private double backgroundHeight = 400;
    private String bckgroundPath = "file:img/desert.png";

    //constructor
    public GameScene(Pane parent, double gameSceneLength, double gameSceneHeight, Camera gameCamera) {
        super(parent, gameSceneLength, gameSceneHeight);
        this.gameCamera = gameCamera;
        //instance of 2 StaticThings to display background (left and right) on the Scene
        this.backgroundLeft = new StaticThing(backgroundLenght,backgroundHeight,bckgroundPath);
        this.backgroundRight = new StaticThing(backgroundLenght,backgroundHeight,bckgroundPath);
        //update image views
        parent.getChildren().addAll(backgroundLeft.getImageView(), backgroundRight.getImageView());
    }

    //Getter
    public Camera getGameCamera() {
        return gameCamera;
    }

    //Render method to modify every position on the Scene according to camera
    public void render(){
        double newOriginX = this.gameCamera.getX();

        this.backgroundRight.getImageView().setX(300-newOriginX);
        this.backgroundLeft.getImageView().setX(-300-newOriginX);

    }
}

