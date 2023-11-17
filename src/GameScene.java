import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {
    //take 3 attributes : two int for the screen size and a camera
    private double gameSceneLength;
    private double gameSceneWidth;
    private Camera gameCamera;

    //constructor
    public GameScene(Parent parent,double gameSceneLength,double gameSceneWidth,Camera gameCamera) {
        super(parent, gameSceneLength, gameSceneWidth);
        this.gameCamera = gameCamera;
    }

    //Getter
    public Camera getGameCamera() {
        return gameCamera;
    }
}

