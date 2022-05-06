package tetris.game;

import java.util.function.Consumer;
import java.util.function.Predicate;

import javafx.beans.property.DoubleProperty;

public class Figure {
	private final Cell[] cells;
	private int position = 1;
	
	private final FigureTemplate template;
	
	public Figure(DoubleProperty size, DoubleProperty borderX, DoubleProperty borderY, int dx) {
		this.template = FigureTemplate.values()[(int)(Math.random() * FigureTemplate.values().length)];
		this.cells = template.getCells(dx);
		
		for(Cell cell: this.cells) {
			cell.bindToSize(size, borderX, borderY);
		}
	}

	public boolean isConditionMet(Predicate<Cell> condition) {
		for(Cell cell: cells) {
			if(condition.test(cell)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void rotate() {
		template.rotate(cells, position++);
		
		if(position > template.rotations) {
			position = 1;
		}
	}
	
	public void rotateBack() {
		int position = this.position - 1 == 0 ? template.rotations : this.position - 1;
		
		while(this.position != position) {
			rotate();
		}
	}
	
	public void move(Consumer<Cell> action) {
		for(Cell cell: cells) {
			action.accept(cell);
		}
	}
	
	public Cell[] getCells() {
		return cells;
	}

	public int getPosition() {
		return position;
	}
}
