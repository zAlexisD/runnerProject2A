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
    private int indexMax = 6;
    private double frameDuration = 0.1;    //30 FPS
    private double frameOffset;
    private double characterFrameX = 5;
    private double characterFrameY = 168;
    private double characterBoxLenght = 47.2;
    private double CharacterBoxHeigth = 50;

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
    public int animatedThingUpdate(long time){
        //Calculate duration in seconds
        double timeSeconds = time / 1000000000.0;
        //Update index by duration
        index = (int) (timeSeconds / frameDuration) % indexMax;
        return index;
    }
}
