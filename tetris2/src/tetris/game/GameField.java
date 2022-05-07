package tetris.game;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

import static tetris.Main.ROWS;
import static tetris.Main.COLUMNS;

public class GameField {
	private final DoubleProperty size;
	private final DoubleProperty borderX;
	private final DoubleProperty borderY;
	
	private final List<Node> list;
	private Figure figure;
	private int removedRows = 0;
	
	private final boolean[][] grid = new boolean[ROWS][COLUMNS];
	
	private final Predicate<Cell> isLeftCorner = cell -> cell.x.get() == -1;
	private final Consumer<Cell> moveLeft = cell -> cell.x.set(cell.x.get() - 1);
	private final Predicate<Cell> isRightCorner = cell -> cell.x.get() == COLUMNS;
	private final Consumer<Cell> moveRight = cell -> cell.x.set(cell.x.get() + 1);
	private final Predicate<Cell> isFloor = cell -> cell.y.get() == ROWS;
	private final Consumer<Cell> moveDown = cell -> cell.y.set(cell.y.get() + 1);
	private final Predicate<Cell> isCeil = cell -> cell.y.get() < 0;
	private final Consumer<Cell> moveUp = cell -> cell.y.set(cell.y.get() - 1);
	
	public GameField(DoubleProperty size, DoubleProperty borderX, DoubleProperty borderY, List<Node> list) {
		this.size = size;
		this.borderX = borderX;
		this.borderY = borderY;
		this.list = list.subList(list.size(), list.size());
		
		setRandomFigure();
	}

	private void setRandomFigure() {
		figure = new Figure(size, borderX, borderY, COLUMNS / 2);
		list.addAll(Arrays.asList(figure.getCells()));
	}
	
	public void restart() {
		list.clear();
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				grid[i][j] = false;
			}
		}
		
		removedRows = 0;
		setRandomFigure();
	}
	
	public boolean moveFigure(KeyCode action) {
		switch(action) {
		case LEFT:
			figure.move(moveLeft);
			
			if(figure.isConditionMet(isLeftCorner) || isSpaceOccupied()) {
				figure.move(moveRight);
			}
			break;
		case RIGHT:
			figure.move(moveRight);
			
			if(figure.isConditionMet(isRightCorner) || isSpaceOccupied()) {
				figure.move(moveLeft);
			}
			break;
		case UP:
			figure.rotate();
			
			if(figure.isConditionMet(isLeftCorner) 
				|| figure.isConditionMet(isRightCorner)
				|| isSpaceOccupied() ) {
				
				figure.rotateBack();
			}
			break;
		case DOWN:
			figure.move(moveDown);
			
			if(figure.isConditionMet(isFloor) || isSpaceOccupied()) {
				figure.move(moveUp);
				
				if(figure.isConditionMet(isCeil)) {
					return false;
				}
				
				fillGrid();
				setRandomFigure();
			}
			break;
		default:
			break;
		}
		
		removeFilledRows();
		return true;
	}
	
	private boolean isSpaceOccupied() {
		for(Cell cell: figure.getCells()) {
			if(cell.y.get() > -1 && grid[cell.y.get()][cell.x.get()]) {
				return true;
			}
		}
		
		return false;
	}
	
	private void fillGrid() {
		for(Cell cell: figure.getCells()) {
			grid[cell.y.get()][cell.x.get()] = true;
		}
	}
	
	private void removeFilledRows(int end, int shift) {
		int start = end - shift;
		
		list.removeIf(cell -> ((Cell) cell).y.get() >= start && ((Cell) cell).y.get() < end);
		
		list.stream()
			.filter(cell -> ((Cell) cell).y.get() < start)
			.forEach(cell -> ((Cell) cell).y.set(((Cell) cell).y.get() + shift));
		
		for(int i = end - shift - 1; i >= 0; i--) {
			for(int j = 0; j < grid[0].length; j++) {
				grid[i + shift][j] = grid[i][j];
			}
		}
		
		for(int i = 0; i < shift; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				grid[i][j] = false;
			}
		}
	}
	
	private void removeFilledRows() {
		int filledRows = 0;
		
		for(int i = 0; i < grid.length; i++) {
			boolean rowFilled = true;
			
			for(boolean cell: grid[i]) {
				if(!cell) {
					rowFilled = false;
					break;
				}
			}
			
			if(rowFilled) {
				filledRows++;
				removedRows++;
			} else {
				if(filledRows != 0) {
					removeFilledRows(i, filledRows);
					filledRows = 0;
				}
			}
		}
		
		if(filledRows != 0) {
			removeFilledRows(grid.length, filledRows);
		}
	}
	
	public int getRemovedRows() {
		return removedRows;
	}
}
