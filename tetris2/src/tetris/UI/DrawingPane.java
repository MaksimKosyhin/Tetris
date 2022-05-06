package tetris.UI;

import javafx.animation.Animation.Status;

import static tetris.game.GameField.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import tetris.game.GameField;

public class DrawingPane extends BorderPane{
	private final DoubleProperty size = new SimpleDoubleProperty(Double.MAX_VALUE);
	private final DoubleProperty borderX = new SimpleDoubleProperty();
	private final DoubleProperty borderY = new SimpleDoubleProperty();
	
	private static final int FRAME_DELAY = 500;
	private static final double RATE_INCREASE = 0.5;
	private static final int CHECKPOINT_STEP = 1;
	
	private final GameField game; 
	private final Timeline animation;
	private double currentRate = 1;
	private int checkPoint = CHECKPOINT_STEP;
	
	public DrawingPane() {
		ChangeListener<Number> sizeChange = (observable, oldVal, newVal) -> {
			size.set(Math.min(this.widthProperty().get()
					/ COLUMNS, this.heightProperty().get() / ROWS));
			
			borderX.set(Math.abs(size.get() * COLUMNS - this.widthProperty().get()) / 2);
			borderY.set(Math.abs(size.get() * ROWS - this.heightProperty().get()) / 2);
		};

		this.widthProperty().addListener(sizeChange);
		this.heightProperty().addListener(sizeChange);
		
		Rectangle border = new Rectangle(0, 0, 0, 0);
		border.setFill(null);
		border.setStroke(Color.WHITE);
		border.xProperty().bind(borderX);
		border.widthProperty().bind(size.multiply(COLUMNS));
		border.yProperty().bind(borderY);
		border.heightProperty().bind(size.multiply(ROWS));
		
		this.getChildren().add(border);
		
		game = new GameField(size, borderX, borderY, this.getChildren());
		
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(new KeyFrame(Duration.millis(FRAME_DELAY), e -> processGameTurn(KeyCode.DOWN)));
		animation.setRate(currentRate);
		
		this.setOnKeyPressed(e -> {
			if(animation.getStatus() == Status.PAUSED) {
				if(e.getCode() == KeyCode.ENTER) {
					game.restart();
					animation.setRate(currentRate);
					animation.play();
				}
			} else {
				processGameTurn(e.getCode());
			}
		});
		
		animation.play();
	}
	
	private void processGameTurn(KeyCode code) {
		
		if(!game.moveFigure(code)) {
			animation.pause();
			checkPoint = CHECKPOINT_STEP;
			currentRate = 1;
		}
		
		int rowsAboveCheckPoint = game.getRemovedRows() - checkPoint;
		
		if(rowsAboveCheckPoint >= 0) {
			int checkPointsPassed = 1 + rowsAboveCheckPoint / CHECKPOINT_STEP;
			
			checkPoint += checkPointsPassed * CHECKPOINT_STEP;
			currentRate += checkPointsPassed * RATE_INCREASE;
			animation.setRate(currentRate);
		}
	}
}
