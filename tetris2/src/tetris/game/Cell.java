package tetris.game;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle{
	public IntegerProperty x, y;
	
	public Cell(int x, int y, Color c) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		
		setFill(c);
		setStroke(Color.WHITE);
	}
	
	public void bindToSize(DoubleProperty size, DoubleProperty borderX, DoubleProperty borderY) {
		xProperty().bind(this.x.multiply(size).add(borderX));
		yProperty().bind(this.y.multiply(size).add(borderY));
		widthProperty().bind(size);
		heightProperty().bind(size);
	}
}
