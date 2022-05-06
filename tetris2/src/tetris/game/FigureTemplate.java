package tetris.game;

import javafx.scene.paint.Color;

public enum FigureTemplate {
	
	// ##
	// ##
	TYPE1(new int[][] {{0, -2}, {1, -2}, {0, -1}, {1, -1}}, 1, Color.CYAN){

		@Override
		void rotate(Cell[] cells, int position) {
		}

	},
	
	//  #
	// ##
	// #
	TYPE2(new int[][] {{1, -3}, {0, -2}, {1, -2}, {0, -1}}, 2, Color.ORANGE){

		@Override
		void rotate(Cell[] cells, int position) {
			switch(position) {
			case 1:
				cells[0].x.set(cells[0].x.get() - 2);
				
				cells[2].x.set(cells[2].x.get() - 1);
				cells[2].y.set(cells[2].y.get() - 1);
				
				cells[3].x.set(cells[3].x.get() + 1);
				cells[3].y.set(cells[3].y.get() - 1);
				break;
			case 2: 
				cells[0].x.set(cells[0].x.get() + 2);
				
				cells[2].x.set(cells[2].x.get() + 1);
				cells[2].y.set(cells[2].y.get() + 1);
				
				cells[3].x.set(cells[3].x.get() - 1);
				cells[3].y.set(cells[3].y.get() + 1);
				break;
			default:
				System.err.println("what");
			}
		}

	},

	//  #
	// ###
	TYPE3(new int[][] {{1, -2}, {0, -1}, {1, -1}, {2, -1}}, 4, Color.VIOLET){

		@Override
		void rotate(Cell[] cells, int position) {
			switch(position) {
			case 1:
				cells[0].y.set(cells[0].y.get() + 1);
				
				cells[1].y.set(cells[1].y.get() - 1);
				
				cells[2].x.set(cells[2].x.get() - 1);
				
				cells[3].x.set(cells[3].x.get() - 2);
				cells[3].y.set(cells[3].y.get() + 1);
				break;
			case 2: 
				cells[0].y.set(cells[0].y.get() + 1);
				
				cells[1].x.set(cells[1].x.get() + 2);
				cells[1].y.set(cells[1].y.get() + 1);
				
				cells[2].x.set(cells[2].x.get() + 1);
				
				cells[3].y.set(cells[3].y.get() - 1);
				break;
			case 3:
				cells[0].y.set(cells[0].y.get() - 1);
				
				cells[1].y.set(cells[1].y.get() + 1);
				
				cells[2].x.set(cells[2].x.get() + 1);
				
				cells[3].x.set(cells[3].x.get() + 2);
				cells[3].y.set(cells[3].y.get() - 1);
				break;
			case 4:
				cells[0].y.set(cells[0].y.get() - 1);
				
				cells[1].x.set(cells[1].x.get() - 2);
				cells[1].y.set(cells[1].y.get() - 1);
				
				cells[2].x.set(cells[2].x.get() - 1);
				
				cells[3].y.set(cells[3].y.get() + 1);
				break;
			default:
				System.err.println("what");
			}
		}

	},

	// #
	// #
	// #
	// #
	TYPE4(new int[][] {{0, -4}, {0, -3}, {0, -2}, {0, -1}}, 2, Color.RED){

		@Override
		void rotate(Cell[] cells, int position) {
			switch(position) {
			case 1:
				cells[0].x.set(cells[0].x.get() - 1);
				cells[0].y.set(cells[0].y.get() + 1);
				
				cells[2].x.set(cells[2].x.get() + 1);
				cells[2].y.set(cells[2].y.get() - 1);
				
				cells[3].x.set(cells[3].x.get() + 2);
				cells[3].y.set(cells[3].y.get() - 2);
				break;
			case 2: 
				cells[0].x.set(cells[0].x.get() + 1);
				cells[0].y.set(cells[0].y.get() - 1);
				
				cells[2].x.set(cells[2].x.get() - 1);
				cells[2].y.set(cells[2].y.get() + 1);
				
				cells[3].x.set(cells[3].x.get() - 2);
				cells[3].y.set(cells[3].y.get() + 2);
				break;
			default:
				System.err.println("what");
			}
		}

	},
	
	// #
	// ###
	TYPE5(new int[][] {{0, -2}, {0, -1}, {1, -1}, {2, -1}}, 4, Color.BLUE){

		@Override
		void rotate(Cell[] cells, int position) {
			switch(position) {
			case 1:
				cells[0].x.set(cells[0].x.get() + 2);
				
				cells[1].x.set(cells[1].x.get() + 1);
				cells[1].y.set(cells[1].y.get() - 1);
				
				cells[3].x.set(cells[3].x.get() - 1);
				cells[3].y.set(cells[3].y.get() + 1);
				break;
			case 2: 
				cells[0].y.set(cells[0].y.get() + 2);
				
				cells[1].x.set(cells[1].x.get() + 1);
				cells[1].y.set(cells[1].y.get() + 1);
				
				cells[3].x.set(cells[3].x.get() - 1);
				cells[3].y.set(cells[3].y.get() - 1);
				break;
			case 3:
				cells[0].x.set(cells[0].x.get() - 2);
				
				cells[1].x.set(cells[1].x.get() - 1);
				cells[1].y.set(cells[1].y.get() + 1);
				
				cells[3].x.set(cells[3].x.get() + 1);
				cells[3].y.set(cells[3].y.get() - 1);
				break;
			case 4:
				cells[0].y.set(cells[0].y.get() - 2);
				
				cells[1].x.set(cells[1].x.get() - 1);
				cells[1].y.set(cells[1].y.get() - 1);
				
				cells[3].x.set(cells[3].x.get() + 1);
				cells[3].y.set(cells[3].y.get() + 1);
				break;
			default:
				System.err.println("what");
			}
		}

	},
	
	//   #
	// ###
	TYPE6(new int[][] {{2, -2}, {0, -1}, {1, -1}, {2, -1}}, 4, Color.YELLOW){

		@Override
		void rotate(Cell[] cells, int position) {
			switch(position) {
			case 1:
				cells[0].y.set(cells[0].y.get() + 2);
				
				cells[1].x.set(cells[1].x.get() + 1);
				cells[1].y.set(cells[1].y.get() - 1);
				
				cells[3].x.set(cells[3].x.get() - 1);
				cells[3].y.set(cells[3].y.get() + 1);
				break;
			case 2: 
				cells[0].x.set(cells[0].x.get() - 2);
				
				cells[1].x.set(cells[1].x.get() + 1);
				cells[1].y.set(cells[1].y.get() + 1);
				
				cells[3].x.set(cells[3].x.get() - 1);
				cells[3].y.set(cells[3].y.get() - 1);
				break;
			case 3:
				cells[0].y.set(cells[0].y.get() - 2);
				
				cells[1].x.set(cells[1].x.get() - 1);
				cells[1].y.set(cells[1].y.get() + 1);
				
				cells[3].x.set(cells[3].x.get() + 1);
				cells[3].y.set(cells[3].y.get() - 1);
				break;
			case 4:
				cells[0].x.set(cells[0].x.get() + 2);
				
				cells[1].x.set(cells[1].x.get() - 1);
				cells[1].y.set(cells[1].y.get() - 1);
				
				cells[3].x.set(cells[3].x.get() + 1);
				cells[3].y.set(cells[3].y.get() + 1);
				break;
			default:
				System.err.println("what");
			}
		}

	},
	
	//#
	//##
	// #
	TYPE7(new int[][] {{0, -3}, {0, -2}, {1, -2}, {1, -1}}, 2, Color.GREEN){

		@Override
		void rotate(Cell[] cells, int position) {
			switch(position) {
			case 1:
				cells[0].y.set(cells[0].y.get() + 1);
				
				cells[1].x.set(cells[1].x.get() + 1);
				
				cells[2].y.set(cells[2].y.get() - 1);
				
				cells[3].x.set(cells[3].x.get() + 1);
				cells[3].y.set(cells[3].y.get() - 2);
				break;
			case 2: 
				cells[0].y.set(cells[0].y.get() - 1);
				
				cells[1].x.set(cells[1].x.get() - 1);
				
				cells[2].y.set(cells[2].y.get() + 1);
				
				cells[3].x.set(cells[3].x.get() - 1);
				cells[3].y.set(cells[3].y.get() + 2);
				break;
			default:
				System.err.println("what");
			}
		}
		
	};
	
	

	private FigureTemplate(int[][] points, int rotations, Color c) {
		this.points = points;
		this.rotations = rotations;
		this.c = c;
	}

	final int[][] points;
	public final int rotations;
	final Color c;
	
	public Cell[] getCells(int dx) {
		Cell[] cells = new Cell[points.length];
		
		for(int i = 0; i < points.length; i++) {
			cells[i] = new Cell(points[i][0] + dx, points[i][1], c);
		}
		
		return cells;
	}
	
	abstract void rotate(Cell[] cells, int position);	
}
