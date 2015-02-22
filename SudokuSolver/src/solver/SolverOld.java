package solver;

import java.util.*;

public class SolverOld {
	private int[][] table;
	private Square[][] squares;

	public SolverOld(int[][] table) {
		this.table = table;
		squares = new Square[9][9];
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int e = 1; e < 10; e++){
			list.add(e);
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				squares[i][j] = new Square(table[i][j], (LinkedList<Integer>) list.clone());
//				squares[i][j].value = table[i][j];
			}
		}
		print();
	}

	/**
	 * Recursive method for solving a sudoku puzzle.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean solve(int i, int j) {
//		System.out.println("Kommer jag hit?");
		if (squares[i][j].value > 0) {
			int[] pos = getIndex(i, j);
			if(i == 9 && j == 9){
				for(int x = 0; x < 9; x++){
					for( int y = 0; y < 9; y++){
						if(!squares[x][y].solved()){
							return solve(x,y);
						}
					}
				}
				squares.toString();
				return true;
			}
			return solve(pos[0], pos[1]);
		} else {
			checkToBox(i, j);
			checkToXRow(i, j);
			checkToYRow(i, j);
			if(squares[i][j].solved()){
				try {
					squares[i][j].fillValue();
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			int[] pos = getIndex(i, j);
			return solve(pos[0], pos[1]);
		}
	}

	/**
	 * Checks current square on sudoku board towards its horizontal row
	 * eliminating all nonpossible alternatives form the squares list.
	 * 
	 * @param i
	 * @param j
	 */
	private void checkToXRow(int i, int j) {
		Square square = squares[i][j];
		if (!square.solved()) {
			Iterator<Integer> itr = square.list.iterator();
			while (itr.hasNext()) {
				int val = itr.next();
				for (int index = 0; i < 9; index++) {
					if (i != index) {
						if (val == squares[index][j].value) {
							itr.remove();
						}
					}
				}
			}
		}
	}

	/**
	 * Checks current square on sudoku board towards its vertical row
	 * eliminating all nonpossible alternatives form the squares list.
	 * 
	 * @param i
	 * @param j
	 */
	private void checkToYRow(int i, int j) {
		Square square = squares[i][j];
		if (!square.solved()) {
			Iterator<Integer> itr = square.list.iterator();
			while (itr.hasNext()) {
				int val = itr.next();
				for (int index = 0; i < 9; index++) {
					if (j != index) {
						if (val == squares[i][index].value) {
							itr.remove();
						}
					}
				}
			}
		}
	}

	/**
	 * Checks current square on sudoku board towards its own 3x3 square
	 * eliminating all nonpossible alternatives form the squares list.
	 * 
	 * @param i
	 * @param j
	 */
	private void checkToBox(int i, int j) {
		Square square = squares[i][j];
		if (!square.solved()) {
			Iterator<Integer> itr = square.list.iterator();
			while (itr.hasNext()) {
				int val = itr.next();
				int x = ((i / 3) * 3);
				int y = ((j / 3) * 3);
				for (int xIndex = x; xIndex < x + 3; xIndex++) {
					for (int yIndex = y; yIndex < y + 3; yIndex++) {
						if (i != xIndex && j != yIndex) {
							if (val == squares[xIndex][yIndex].value) {
								itr.remove();
							}
						}
					}
				}
			}
		}
		System.out.println(square.list.toString());
	}

	/**
	 * Computes next logical index of the table in chronological order.
	 * 
	 * @param i
	 * @param j
	 * @return Array containing the x & y indexes in that order.
	 */
	private int[] getIndex(int i, int j) {
		int x = i + 1;
		int y = j;
		if (x == 9) {
			x = 0;
			y += 1;
			if (y == 9) {
				y = 0;
			}
		}

		return new int[] { x, y };
	}
	
	public void print(){
		StringBuilder sb = new StringBuilder();
		System.out.print("[");
		for(int i = 0; i < 9; i ++){
			System.out.print("[");
			for(int j = 0; j < 9; j++){
				System.out.print(squares[i][j].toString() +", ");
			}
			System.out.print("],");
			System.out.println();
		}
		System.out.println("]");
	}

	public static class Square {
		private int value;
		private LinkedList<Integer> list;

		public Square(int value, LinkedList<Integer> list) {
			this.value = value;
			this.list = list;
			if(value > 0){
				list.clear();
				list.add(value);
			}
//			list = new LinkedList<Integer>();
//			for (int i = 1; i < 10; i++) {
//				list.add(i);
//			}
		}
		
		public void fillValue() throws Exception{
			if(solved()){
				value = list.getFirst();				
			} else {
				throw new Exception("There should only be 1 item in this list if we get here!");
			}
		}

		public boolean solved() {
			return list.size() == 1;
		}
		
		public String toString(){
			return String.valueOf(value);
		}
	}
}
