package tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tetris.UI.DrawingPane;

public class Main extends Application{
	// you can change all of this fields if you want
	
	// delay for frame of animation
	// it's an initial speed of the game
	public static final int FRAME_DELAY = 500;
	// increases game speed
	public static final double RATE_INCREASE = 3;
	// number of removed rows after which game speed is increased
	public static final int CHECKPOINT_STEP = 1;
	
	// number of rows and columns that game field has
	public static final int ROWS = 20;
	public static final int COLUMNS = 15;
	
	@Override
    public void start(Stage stage) {
		Pane pane = new DrawingPane();
		
        Scene scene = new Scene(pane, 640, 480);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
        
        pane.requestFocus();
    }
	
    public static void main(String[] args) {
        launch();
    }

}