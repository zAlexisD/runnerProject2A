import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    // Final variables
    private final double heroBoxLenght = 381;
    private final double heroBoxHeigth = 381;
    private final double heroSizeX = 94.4;
    private final double heroSizeY = 100;
    private double heroFrameX = 0;
    private double heroFrameY = 0;
    // Variables + Constants
    private final int indexMax = 4;
    private double heroSpeedX;
    private final double K_CONSTANT = 50;
    private double F_CONSTANT = 5;
    private final double MASS = 1000;
    private boolean isJumping;
    private double jumpSpeedY;
    private static final double JUMP_INITIAL_SPEED = -600;
    private final double GROUND_LEVEL = 260;
    private final double GRAVITY = 1300;

    public Hero(double x, double y, int attitude, String heroFileName) {
        super(x, y, attitude, heroFileName);
        getspriteSheetImageView().setViewport(new Rectangle2D(heroFrameX,heroFrameY,heroBoxLenght,heroBoxHeigth));
        getspriteSheetImageView().setFitWidth(heroSizeX);
        getspriteSheetImageView().setFitHeight(heroSizeY);
        getspriteSheetImageView().setX(x);
        getspriteSheetImageView().setY(y);
    }

    // stand method

    // run method
    public void runHero(int index){
        this.getspriteSheetImageView().setViewport(new Rectangle2D( index * 381,0,370,381 ));
    }
    // Jump check for event
    public void jump() {
        if (!isJumping) {
            // Only allow jumping if not currently in the air
            jumpSpeedY = JUMP_INITIAL_SPEED;
            isJumping = true;
        }
    }
    // jump method
    public void jumpHero(double time){
        // Handle jumping
        if (isJumping) {
            // Update vertical position based on jump speed
            setY(getY() + jumpSpeedY * time);

            // Update jump speed based on gravity (adjust as needed)
            jumpSpeedY += GRAVITY * time;
            System.out.println(getY());
            // Check if the hero has landed
            if (getY() >= GROUND_LEVEL) {
                setY(GROUND_LEVEL);  // Snap to ground level
                isJumping = false;
                jumpSpeedY = 0.0;  // Reset jump speed
            }
        }
    }

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
        F_CONSTANT += 0.0003;
        // camera X = velocityX integration = velocityX * time difference
        // heroX += heroSpeedX * time;
        // Updates
        int index = animatedThingUpdate(time,indexMax);
        runHero(index);
        setX(getX() + heroSpeedX * time);
        getspriteSheetImageView().setX(getX());
        // Print out position for tests
        // System.out.println(getX());
        jumpHero(time);
    }
}
