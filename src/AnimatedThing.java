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
    private int indexMax = 4;
    private double frameDuration = 0.1;
    private double frameOffset;
    private double characterFrameX = 0;
    private double characterFrameY = 0;
    private double characterBoxLenght = 381;
    private double CharacterBoxHeigth = 381;
    private double characterSizeX = 94.4;
    private double characterSizeY = 100;

    public AnimatedThing(double x, double y, int attitude,String fileName) {
        Image Sheet = new Image(fileName);
        this.spriteSheetImageView = new ImageView(Sheet);
        //First frame
        spriteSheetImageView.setViewport(new Rectangle2D(characterFrameX,characterFrameY,characterBoxLenght,CharacterBoxHeigth));
        //Set starting position
        spriteSheetImageView.setX(x);
        spriteSheetImageView.setY(y);
        //Adapt character size on screen
        spriteSheetImageView.setFitWidth(characterSizeX);
        spriteSheetImageView.setFitHeight(characterSizeY);

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
