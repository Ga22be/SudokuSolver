package solver;

import java.util.*;

public class Solver {
	private Square[][] squares;
	private boolean calculated;
	private boolean solved;

	/**
	 * Creates a new sudoku solver
	 */
	public Solver() {
		calculated = false;
		solved = false;
	}

	public boolean solve() {
		int solvedSquares = 0;
		while (!calculated) {
			int savedValue = solvedSquares;
			int[] index = { 0, 0 };
			solvedSquares = solve(index);
			System.out.println(solvedSquares);
			if (solvedSquares == 81) {
				calculated = true;
				solved = true;
				return solved;
			} else if (solvedSquares == savedValue) {
				calculated = true;
				solved = false;
				return solved;
			}
		}
		return solved;
	}

	private int solve(int[] index) {
		if (index[0] == 8 && index[1] == 8) {
			if (squares[index[1]][index[0]].solved()) {
				return 1;
			} else {
				checkToXRow(index);
				checkToYRow(index);
				checkToBox(index);
				if (squares[index[1]][index[0]].solved()) {
					squares[index[1]][index[0]].fillValue();
					return 1;
				}
				return 0;
			}
		} else if (squares[index[1]][index[0]].solved()) {
			nextIndex(index);
			return 1 + solve(index);
		} else {
			checkToXRow(index);
			checkToYRow(index);
			checkToBox(index);
			if (squares[index[1]][index[0]].solved()) {
				squares[index[1]][index[0]].fillValue();
				nextIndex(index);
				return 1 + solve(index);
			}
			nextIndex(index);
			return solve(index);
		}
	}

	/**
	 * Readies the class for a new puzzle. Wiping the old one and adding the new
	 * one.
	 * 
	 * @param sudoku
	 *            Contains the puzzle to be solved.
	 */
	public void newPuzzle(int[][] sudoku) {
		squares = new Square[9][9];
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				squares[y][x] = new Square(sudoku[y][x],
						(LinkedList<Integer>) list.clone());
			}
		}
		calculated = false;
	}

	/**
	 * Checks current square on sudoku board towards its horizontal row
	 * eliminating all nonpossible alternatives from the squares list.
	 * 
	 * @param x
	 *            The x coordinate of the square in the 2D array to be examined.
	 * @param y
	 *            The y coordinate of the square in the 2D array to be examined.
	 */
	private void checkToXRow(int[] index) {
		if (!squares[index[1]][index[0]].solved()) {
			Iterator<Integer> itr = squares[index[1]][index[0]].list.iterator();
			while (itr.hasNext()) {
				int val = itr.next();
				for (int xIndex = 0; xIndex < 9; xIndex++) {
					if (index[0] != xIndex) {
						if (val == squares[index[1]][xIndex].value) {
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
	 * @param x
	 *            The x coordinate of the square in the 2D array to be examined.
	 * @param y
	 *            The y coordinate of the square in the 2D array to be examined.
	 */
	private void checkToYRow(int[] index) {
		if (!squares[index[1]][index[0]].solved()) {
			Iterator<Integer> itr = squares[index[1]][index[0]].list.iterator();
			while (itr.hasNext()) {
				int val = itr.next();
				for (int yIndex = 0; yIndex < 9; yIndex++) {
					if (index[1] != yIndex) {
						if (val == squares[yIndex][index[0]].value) {
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
	 * @param x
	 *            The x coordinate of the square in the 2D array to be examined.
	 * @param y
	 *            The y coordinate of the square in the 2D array to be examined.
	 */
	private void checkToBox(int[] index) {
		if (!squares[index[1]][index[0]].solved()) {
			Iterator<Integer> itr = squares[index[1]][index[0]].list.iterator();
			int xStart = ((index[0] / 3) * 3);
			int yStart = ((index[1] / 3) * 3);
			while (itr.hasNext()) {
				int val = itr.next();
				for (int yIndex = yStart; yIndex < yStart + 3; yIndex++) {
					for (int xIndex = xStart; xIndex < xStart + 3; xIndex++) {
						if (index[0] == xIndex && index[1] == yIndex) {
							// Don't want to check vs own square
						} else {
							if (val == squares[yIndex][xIndex].value) {
								itr.remove();
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Computes next logical index of the table in chronological order.
	 * 
	 * @param index
	 *            Array containing the x & y coordinates in question, int that
	 *            order.
	 */
	private void nextIndex(int[] index) {
		index[0] += 1;
		if (index[0] == 9) {
			index[0] = 0;
			index[1] += 1;
			if (index[1] == 9) {
				index[1] = 0;
			}
		}
	}

	/**
	 * Prints current state of puzzle.
	 */
	public void print() {
		for (int y = 0; y < 9; y++) {
			System.out.print("[");
			for (int x = 0; x < 9; x++) {
				System.out.print(squares[y][x].toString() + ", ");
			}
			System.out.print("],");
			System.out.println();
		}
	}

	/**
	 * Checks if the current puzzle has been calculated to its full extent.
	 * 
	 * @return If calculated to its full extent.
	 */
	public boolean calculated() {
		return calculated;
	}

	public static class Square {
		private int value;
		private LinkedList<Integer> list;

		/**
		 * Creates a new Square object.
		 * 
		 * @param value
		 *            The value of the square. If unknown set to 0.
		 * @param list
		 *            List containing all current possible alternatives for the
		 *            square.
		 */
		public Square(int value, LinkedList<Integer> list) {
			this.value = value;
			this.list = list;
			if (value > 0) {
				list.clear();
				list.add(value);
			}
		}

		/**
		 * Fills the square with the only value left in list.
		 */
		public void fillValue() {
			if (solved()) {
				value = list.getFirst();
			}
		}

		/**
		 * Returns true if square is filled
		 * 
		 * @return True if filled
		 */
		public boolean solved() {
			if (list.size() == 1) {
				value = list.getFirst();
				return true;
			}
			return false;
		}

		/**
		 * @return The current value in string format.
		 */
		public String toString() {
			return String.valueOf(value);
		}
	}

}
