import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    // Variables + Constants
    private double heroSpeedX = 0;
    private final double K_CONSTANT = 50;
    private final double F_CONSTANT = 5;
    private final double MASS = 1000;
    public Hero(double x, double y, int attitude, String fileName) {
        super(x, y, attitude, fileName);
    }

    // stand method

    // run method
    public void runHero(int index){
        this.getspriteSheetImageView().setViewport(new Rectangle2D( index * 381,0,370,381 ));
    }
    // jump method

    // run + shoot method
    public void runShootHero(int index){
        // this.getspriteSheetImageView().setViewport(new Rectangle2D());
    }
    // jump + shoot method

    // Draw method to update the position of the hero based on the camera
    public void draw(Camera camera) {
        getspriteSheetImageView().setX(getX() - camera.getX());
    }

    // update
    public void updateHero(double time,double cameraX){
        // Update equations for X
        // Will not be necessary for Y because camera does not move on y-axis
        double accelX = (K_CONSTANT * (getX()- cameraX) + F_CONSTANT * heroSpeedX) / MASS;
        // velocityX = accelX integration = accelX * time difference
        heroSpeedX += accelX * time;
        // camera X = velocityX integration = velocityX * time difference
        // heroX += heroSpeedX * time;
        // Updates
        int index = animatedThingUpdate(time);
        runHero(index);
        setX(getX() + heroSpeedX * time);
        getspriteSheetImageView().setX(getX());
        // Print out position for tests
        // System.out.println(getX());
    }
}
