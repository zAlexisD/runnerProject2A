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
    private int indexMax;
    private double frameDuration;
    private double frameOffset;
    private double characterFrameX = 20;
    private double characterFrameY = 0;
    private double characterBoxLenght = 65;
    private double CharacterBoxHeigth = 100;

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
}
