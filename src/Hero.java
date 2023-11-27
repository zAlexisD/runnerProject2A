import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    public Hero(double x, double y, int attitude, String fileName) {
        super(x, y, attitude, fileName);
    }

    //stand method

    //run method

    //jump method

    //run + shoot method
    void runShootHero(int index){
        this.getspriteSheetImageView().setViewport(new Rectangle2D(375 + index * 48.5,248,48,47 ));
    }

    //jump + shoot method

    //update
    void updateHero(long time){
        int index = super.animatedThingUpdate(time);
        runShootHero(index);
    }
}
