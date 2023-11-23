import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {
    //take 3 attributes : two int for the screen size and a camera
    private double gameSceneLength;
    private double gameSceneHeight;
    private Camera gameCamera;
    private StaticThing backgroundLeft;
    private StaticThing backgroundRight;
    //StaticThing variables
    private double backgroundLenght = 800;
    private double backgroundHeight = 600;
    private String bckgroundPath = "file:img/desert.png";

    //constructor
    public GameScene(Parent parent,double gameSceneLength,double gameSceneHeight,Camera gameCamera) {
        super(parent, gameSceneLength, gameSceneHeight);
        this.gameCamera = gameCamera;
        //instanciation of 2 StaticThings to display background (left and right) on the Scene
        this.backgroundLeft = new StaticThing(backgroundLenght,backgroundHeight,bckgroundPath);
        this.backgroundRight = new StaticThing(backgroundLenght,backgroundHeight,bckgroundPath);
    }

    //Getter
    public Camera getGameCamera() {
        return gameCamera;
    }

    //Render method to modify every position on the Scene according to camera

}

