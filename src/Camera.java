/**
 * The Camera class represents a camera with two-dimensional coordinates (x, y).
 * It provides methods to access and manipulate the camera's position.
 */
public class Camera {
    // Two attributes
    private double x;
    private double y;

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

    //Update method with AnimatedTimer
    void cameraUpdate(long timer){
        //empty method for now
    }
}
