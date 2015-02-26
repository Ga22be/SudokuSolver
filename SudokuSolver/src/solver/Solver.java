package solver;

public class Solver {
	private int[][] table;

	public Solver() {
	}

	public Solver(int[][] sudoku) {
		this();
		table = sudoku;
	}

	public void newPuzzle(int[][] sudoku) {
		this.table = sudoku;
	}

	public int[][] getResult() {
		return table;
	}

	public boolean solve() {
		return solve(0, 0);
	}

	private boolean solve(int x, int y) {
		if (x == 8 && y == 8) {
			if (table[y][x] > 0) {
				return checkToXRow(x, y) && checkToYRow(x, y)
						&& checkToBox(x, y);
			} else {
				for (int i = 1; i < 10; i++) {
					table[y][x] = i;
					if (checkToXRow(x, y) && checkToYRow(x, y)
							&& checkToBox(x, y)) {
						return true;
					}
				}
				return false;
			}

		} else {
			if (table[y][x] > 0) {
				if (checkToXRow(x, y) && checkToYRow(x, y) && checkToBox(x, y)) {
					int newX = x;
					int newY = y;
					newX += 1;
					if (newX == 9) {
						newX = 0;
						newY += 1;
						if (newY == 9) {
							newY = 0;
						}
					}
					return solve(newX, newY);
				} else {
					return false;
				}
			} else {
				for (int i = 1; i < 10; i++) {
					boolean solved = false;
					table[y][x] = i;
					if (checkToXRow(x, y) && checkToYRow(x, y)
							&& checkToBox(x, y)) {
						int newX = x;
						int newY = y;
						newX += 1;
						if (newX == 9) {
							newX = 0;
							newY += 1;
							if (newY == 9) {
								newY = 0;
							}
						}
						solved = solve(newX, newY);
						if (solved) {
							return true;
						}
					}
				}
				table[y][x] = 0;
				return false;
			}
		}
		// return false;
	}

	/**
	 * Checks current square on sudoku board towards its horizontal row
	 * eliminating all nonpossible alternatives from the possibilities list.
	 * 
	 * @param x
	 *            The x coordinate of the square in the 2D array to be examined.
	 * @param y
	 *            The y coordinate of the square in the 2D array to be examined.
	 */
	private boolean checkToXRow(int x, int y) {
		for (int xIndex = 0; xIndex < 9; xIndex++) {
			if (x != xIndex) {
				if (table[y][x] == table[y][xIndex]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks current square on sudoku board towards its vertical row
	 * eliminating all nonpossible alternatives from the possibilities list.
	 * 
	 * @param x
	 *            The x coordinate of the square in the 2D array to be examined.
	 * @param y
	 *            The y coordinate of the square in the 2D array to be examined.
	 */
	private boolean checkToYRow(int x, int y) {
		for (int yIndex = 0; yIndex < 9; yIndex++) {
			if (y != yIndex) {
				if (table[y][x] == table[yIndex][x]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks current square on sudoku board towards its own 3x3 square
	 * eliminating all nonpossible alternatives from the possibilities list.
	 * 
	 * @param x
	 *            The x coordinate of the square in the 2D array to be examined.
	 * @param y
	 *            The y coordinate of the square in the 2D array to be examined.
	 */
	private boolean checkToBox(int x, int y) {
		int xStart = ((x / 3) * 3);
		int yStart = ((y / 3) * 3);
		for (int yIndex = yStart; yIndex < yStart + 3; yIndex++) {
			for (int xIndex = xStart; xIndex < xStart + 3; xIndex++) {
				if (x == xIndex && y == yIndex) {
					// Don't want to check vs own square
				} else {
					if (table[y][x] == table[yIndex][xIndex]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Prints current state of puzzle.
	 */
	public void print() {
		for (int y = 0; y < 9; y++) {
			System.out.print("[");
			for (int x = 0; x < 9; x++) {
				System.out.print(table[y][x] + ", ");
			}
			System.out.print("],");
			System.out.println();
		}
	}
}
