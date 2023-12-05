import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Foes extends AnimatedThing{
    private final int indexMax = 6;
    private double foesBoxLenght = 498;
    private double foesBoxHeigth = 498;
    private double foesSizeX = 75.52;
    private double foesSizeY = 80;
    private double foeSpeedX = 100;
    private final double K_CONSTANT = 50;
    private final double F_CONSTANT = 5.5;
    private final double MASS = 1000;

    public Foes(double x, double y, int attitude, String foeFileName) {
        super(x, y, attitude, foeFileName);
        getspriteSheetImageView().setViewport(new Rectangle2D(0,0,foesBoxLenght,foesBoxHeigth));
        getspriteSheetImageView().setFitHeight(foesSizeY);
        getspriteSheetImageView().setFitWidth(foesSizeX);
        getspriteSheetImageView().setX(x);
        getspriteSheetImageView().setY(y);
    }

    // Generate a foe method
    public void generateFoe(Pane pane, String fileName){
        Random random = new Random();
        int generateOrNot = random.nextInt(2);
        if (generateOrNot == 1){
            Foes newFoe = new Foes(550,260,0,fileName);
        }
    }
    // Run foe method
    public void runFoe(int index){
        this.getspriteSheetImageView().setViewport(new Rectangle2D( index * 498,0,498,498 ));
    }

    // Update foe
    public void updateFoe(double time,double cameraX) {
        // Update equations for X
        // Will not be necessary for Y because camera does not move on y-axis
        double accelX = (K_CONSTANT * (getX() - cameraX) + F_CONSTANT * foeSpeedX) / MASS;
        // velocityX = accelX integration = accelX * time difference
        foeSpeedX += accelX * time;
        // camera X = velocityX integration = velocityX * time difference
        // heroX += heroSpeedX * time;
        // Updates
        int index = animatedThingUpdate(time, indexMax);
        runFoe(index);
        setX(getX() - foeSpeedX * time);
        getspriteSheetImageView().setX(getX());
    }
}
