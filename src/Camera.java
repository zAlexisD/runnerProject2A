/**
 * The Camera class represents a camera with two-dimensional coordinates (x, y).
 * It provides methods to access and manipulate the camera's position.
 */
public class Camera {
    // Two attributes
    private int x;
    private int y;

    /**
     * Constructs a new Camera object with the specified x and y coordinates.
     *
     * @param x The x-coordinate of the camera.
     * @param y The y-coordinate of the camera.
     */
    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate of the camera.
     *
     * @return The x-coordinate of the camera.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the camera.
     *
     * @return The y-coordinate of the camera.
     */
    public int getY() {
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
}
