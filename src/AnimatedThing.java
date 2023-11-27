import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//class used as a mold for the hero and its opponent
abstract class AnimatedThing {
    //attributes
    private double x;
    private double y;
    private ImageView spriteSheetImageView;
    private int attitude;
    //variables needed to display animation
    private int index;
    private int indexMax = 8;
    private double frameDuration = 1/30;    //30 FPS
    private double frameOffset = 2;
    private double characterFrameX = 375;
    private double characterFrameY = 248;
    private double characterBoxLenght = 48.5;
    private double CharacterBoxHeigth = 47;

    public AnimatedThing(double x, double y, int attitude,String fileName) {
        Image Sheet = new Image(fileName);
        this.spriteSheetImageView = new ImageView(Sheet);
        spriteSheetImageView.setViewport(new Rectangle2D(characterFrameX,characterFrameY,characterBoxLenght,CharacterBoxHeigth));
        spriteSheetImageView.setX(x);
        spriteSheetImageView.setY(y);

        this.attitude = attitude;
    }
    //getter
    public ImageView getspriteSheetImageView() {return spriteSheetImageView;}

    //Update method with AnimatedTimer
    int animatedThingUpdate(long time){
        //Calculate duration in seconds
        double timeSeconds = time / 1000000000.0;
        //Update index by duration
        index = (int) ((timeSeconds + frameOffset) / frameDuration) % indexMax;
        return index;
    }
}
