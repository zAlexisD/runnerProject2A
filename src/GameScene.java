import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

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
    private Foes theFoe;
    private double staticThingX = 0;
    private double staticThingY = 0;
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
    private double heroBoxLenght;
    private double heroBoxHeigth;
    private double heroSizeX;
    private double heroSizeY;
    private final String heroFileName = "file:img/padoru.png";
    // Foes Variables
    private final String foeFileName = "file:img/kurukuru.png";

    // Constructor
    public GameScene(Pane parent, double gameSceneLength, double gameSceneHeight, Camera gameCamera) {
        super(parent, gameSceneLength, gameSceneHeight);
        this.gameCamera = gameCamera;

        // Instance of 2 StaticThings to display background (left and right) on the Scene
        this.backgroundLeft = new StaticThing(backgroundLenght,backgroundHeight,staticThingX,staticThingY,backgroundPath);
        this.backgroundRight = new StaticThing(backgroundLenght,backgroundHeight,staticThingX,staticThingY,backgroundPath);

        // StaticThing instance to display HP hearts on the Scene
        this.numberOfLives = new StaticThing(heartsBoxLenght,heartsBoxHeight,staticThingX,staticThingY,heartsPath);

        // AnimatedThing instance to display hero
        this.theHero = new Hero(heroX,heroY,attitude,heroFileName);

//        // Generate foes
//        theFoe.generateFoe(parent,foeFileName);

        // Update image views
        parent.getChildren().addAll(backgroundLeft.getImageView(), backgroundRight.getImageView());
        parent.getChildren().addAll(numberOfLives.getImageView(), theHero.getspriteSheetImageView());

        // Set buttons
        setOnKeyPressed((KeyEvent event) -> handleKeyPress(event.getCode()));
    }

    // Getter
    public Camera getGameCamera() {
        return gameCamera;
    }

    // Handling button method
    private void handleKeyPress(KeyCode code){
        switch (code) {
            case SPACE -> theHero.jump();
        }
    }

    // Update method for HP
    public void updateHearts(int lostHP){
        if (lostHP>=5){lostHP=4;}
        this.numberOfLives.getImageView().setViewport(new Rectangle2D(0,60*lostHP,300,60));

        this.numberOfLives.getImageView().setFitWidth(200);
        this.numberOfLives.getImageView().setFitHeight(40);
    }

    // Render method to modify every position on the Scene according to camera
    public void render(){
        // No changes on y-axis
        double newCameraX = this.gameCamera.getX();

        this.backgroundRight.getImageView().setX(getWidth()/2-newCameraX);
        this.backgroundLeft.getImageView().setX(-getWidth()/2-newCameraX);
    }
    // Background update method
    public void backgroundUpdate(){
        // Check if the camera is near the right edge of the backgroundRight
        if (backgroundRight.getX() < gameCamera.getX()) {
            // Move background to the right to create a looping effect
            backgroundLeft.setX(backgroundLeft.getX() + backgroundLeft.getDisplayWidth());
            backgroundRight.setX(backgroundRight.getX() + backgroundRight.getDisplayWidth());
        }
    }

    // Update method with AnimatedTimer
    public void gameSceneUpdate(double time){
        theHero.updateHero(time,gameCamera.getX());
        gameCamera.updateCamera(time,theHero.getX());
        theHero.draw(gameCamera);
        render();
        backgroundUpdate();
    }
}

