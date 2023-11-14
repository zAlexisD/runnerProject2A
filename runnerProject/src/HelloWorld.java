import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world");
        Group root = new Group();
        Pane pane = new Pane(root);
        Scene theScene = new Scene(pane, 600, 400,true);
        primaryStage.setScene(theScene);

        //Display Hero
        Image spriteSheet = new Image("file:img/heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300);
        //Update root
        root.getChildren().add(sprite);

        //Display Desert
        Image spriteSheet2 = new Image("file:img/desert.png",true);
        ImageView sprite2 = new ImageView(spriteSheet2);
        sprite2.setViewport(new Rectangle2D(300,200,600,400));
        root.getChildren().add(sprite2);

        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);

    }
}
