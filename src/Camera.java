/**
 * The Camera class represents a camera with two-dimensional coordinates (x, y).
 * It provides methods to access and manipulate the camera's position.
 */
public class Camera {
    // Two attributes
    private double x;
    private double y;

    // Variables + Constants
    private double cameraSpeedX;
    private final double K_CONSTANT = 50;
    private final double F_CONSTANT = 5;
    private final double MASS = 1000;
    /**
     * Constructs a new Camera object with the specified x and y coordinates.
     *
     * @param x The x-coordinate of the camera.
     * @param y The y-coordinate of the camera.
     */
    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate of the camera.
     *
     * @return The x-coordinate of the camera.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the camera.
     *
     * @return The y-coordinate of the camera.
     */
    public double getY() {
        return y;
    }

    /**
     * Overrides the default toString method to provide a string representation of the Camera object.
     *
     * @return A string representation of the Camera object in the format "x,y".
     */
    @Override
    public String toString() {
        return this.x + "," + this.y;
    }

    // Set camera X position method
    public void cameraSetX(double x){
        this.x = x;
    }

    // Update method with AnimatedTimer
    public void updateCamera(double time,double heroX){
        // Update equations for X
        // Will not be necessary for Y because camera does not move on y-axis
        double accelX = (K_CONSTANT * (heroX - getX()) + F_CONSTANT * cameraSpeedX) / MASS;
        // velocityX = accelX integration = accelX * time difference
        cameraSpeedX += accelX * time;
        // camera X = velocityX integration = velocityX * time difference
        // Set camera x position
        cameraSetX(getX() + cameraSpeedX * time);
        // Print out position for tests
        System.out.println(heroX - getX());
    }
}
