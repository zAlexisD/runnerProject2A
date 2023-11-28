import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    public Hero(double x, double y, int attitude, String fileName) {
        super(x, y, attitude, fileName);
    }

    //stand method

    //run method
    public void runHero(int index){
        this.getspriteSheetImageView().setViewport(new Rectangle2D( index * 381,0,370,381 ));
    }
    //jump method

    //run + shoot method
    public void runShootHero(int index){
        this.getspriteSheetImageView().setViewport(new Rectangle2D( index * 381,0,370,381 ));
    }
    //jump + shoot method

    //update
    public void updateHero(long time){
        int index = animatedThingUpdate(time);
        runHero(index);
    }
}
