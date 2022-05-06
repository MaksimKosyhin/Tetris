package tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tetris.UI.DrawingPane;

public class Main extends Application{
	public static final int ROWS = 20, COLUMNS = 15;
	
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
