import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.awt.*;

public class GameScene extends Scene {
    // Take 3 attributes : two int for the screen size and a camera
    private double gameSceneLength;
    private double gameSceneHeight;
    private Camera gameCamera;
    // StaticThings
    private StaticThing backgroundLeft;
    private StaticThing backgroundRight;
    private StaticThing numberOfLives;
    private Hero theHero;
    // Variables for Left and Right
    private double backgroundLenght = 600;
    private double backgroundHeight = 400;
    private String backgroundPath = "file:img/desert.png";
    // Variables for hearts
    private double heartsBoxLenght = 300;
    private double heartsBoxHeight = 60;
    private String heartsPath = "file:img/hearts.png";
    // Variables for Hero
    private double heroX = 75;
    private double heroY = 260;
    private int attitude = 0;
    private String heroPath = "file:img/padoru.png";

    // Constructor
    public GameScene(Pane parent, double gameSceneLength, double gameSceneHeight, Camera gameCamera) {
        super(parent, gameSceneLength, gameSceneHeight);
        this.gameCamera = gameCamera;

        //instance of 2 StaticThings to display background (left and right) on the Scene
        this.backgroundLeft = new StaticThing(backgroundLenght,backgroundHeight,backgroundPath);
        this.backgroundRight = new StaticThing(backgroundLenght,backgroundHeight,backgroundPath);

        //StaticThing instance to display HP hearts on the Scene
        this.numberOfLives = new StaticThing(heartsBoxLenght,heartsBoxHeight,heartsPath);

        //AnimatedThing instance to display hero
        this.theHero = new Hero(heroX,heroY,attitude,heroPath);

        //update image views
        parent.getChildren().addAll(backgroundLeft.getImageView(), backgroundRight.getImageView());
        parent.getChildren().addAll(numberOfLives.getImageView(), theHero.getspriteSheetImageView());
    }

    // Getter
    public Camera getGameCamera() {
        return gameCamera;
    }



    // Update method for HP
    public void updateHearts(int lostHP){
        if (lostHP>=5){lostHP=4;}
        this.numberOfLives.getImageView().setViewport(new Rectangle2D(0,60*lostHP,300,60));

        this.numberOfLives.getImageView().setFitWidth(200);
        this.numberOfLives.getImageView().setFitHeight(40);
        this.numberOfLives.getImageView().setX(0);
        this.numberOfLives.getImageView().setY(0);
    }

    // Render method to modify every position on the Scene according to camera
    public void render(){
        // No changes on y-axis
        double newCameraX = this.gameCamera.getX();

        this.backgroundRight.getImageView().setX(getWidth()/2-newCameraX);
        this.backgroundLeft.getImageView().setX(-getWidth()/2-newCameraX);
    }
    // Background update method
    public void backgroundUpdate(Pane pane){
        if (gameCamera.getX()>300){

        }
    }

    // Update method with AnimatedTimer
    public void gameSceneUpdate(double time){
        theHero.updateHero(time,gameCamera.getX());
        gameCamera.updateCamera(time,theHero.getX());
        theHero.draw(gameCamera);
        render();
    }
}

