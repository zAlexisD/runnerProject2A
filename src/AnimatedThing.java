import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

// Class used as a mold for the hero and its opponent
abstract class AnimatedThing {
    // Attributes
    private double x;
    private double y;
    private ImageView spriteSheetImageView;
    private int attitude;
    // Variables needed to display animation
    private int index;
    private double frameDuration = 0.1;
    private double frameOffset;
    private double characterFrameX = 0;
    private double characterFrameY = 0;
//    private double characterBoxLenght;
//    private double characterBoxHeigth;
//    private double characterSizeX;
//    private double characterSizeY;

    public AnimatedThing(double x, double y, int attitude,String characterFileName) {
        this.x = x;
        this.y = y;
        this.attitude = attitude;

        Image Sheet = new Image(characterFileName);
        this.spriteSheetImageView = new ImageView(Sheet);
//        // First frame
//        spriteSheetImageView.setViewport(new Rectangle2D(characterFrameX,characterFrameY,characterBoxLenght,characterBoxHeigth));
//        // Set starting position
//        spriteSheetImageView.setX(x);
//        spriteSheetImageView.setY(y);
//        // Adapt character size on screen
//        spriteSheetImageView.setFitWidth(characterSizeX);
//        spriteSheetImageView.setFitHeight(characterSizeY);
    }
    // Getter
    public ImageView getspriteSheetImageView() {return spriteSheetImageView;}
    public double getX() {return x;}
    public double getY() {return y;}

    //  Set the x position method
    public void setX(double x) {
        this.x = x;
        spriteSheetImageView.setX(x);
    }
    // Set the y position method
    public void setY(double y) {
        this.y = y;
        spriteSheetImageView.setY(y);
    }

    // Update method with AnimatedTimer
    public int animatedThingUpdate(double time, int indexMax){
        // Calculate duration in seconds
        double timeSeconds = time * 1e6;
        // Update index by duration
        index = (int) (timeSeconds / frameDuration) % indexMax;
        return index;
    }
}
