package test;

import solver.OptimizedSolver;

public class TestOptimizedSolver {

	public static void main(String[] args) {
		int[][] sudoku1 = { 
			{ 9, 0, 6, 8, 1, 3, 5, 4, 0 },
			{ 2, 0, 1, 0, 4, 5, 0, 6, 3 }, 
			{ 0, 4, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 6, 2, 0, 0, 0, 9 }, 
			{ 0, 0, 9, 0, 0, 0, 2, 0, 0 },
			{ 7, 0, 0, 0, 3, 4, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 9, 0 },
			{ 5, 9, 0, 3, 6, 0, 1, 0, 4 }, 
			{ 0, 2, 7, 4, 5, 9, 3, 0, 6 }
		};
		
		int[][] sudoku2 = {
			{ 1, 0, 0, 0, 7, 0, 0, 0, 0 },
			{ 0, 6, 0, 4, 0, 0, 7, 0, 1 }, 
			{ 0, 0, 2, 0, 1, 0, 5, 9, 0 },
			{ 0, 0, 3, 2, 0, 0, 0, 6, 0 }, 
			{ 7, 0, 0, 5, 0, 9, 0, 0, 3 },
			{ 0, 8, 0, 0, 0, 7, 1, 0, 0 }, 
			{ 0, 4, 5, 0, 9, 0, 6, 0, 0 },
			{ 9, 0, 1, 0, 0, 4, 0, 7, 0 }, 
			{ 0, 0, 0, 0, 2, 0, 0, 0, 4 }
		};
		
		OptimizedSolver solver = new OptimizedSolver();
		solver.newPuzzle(sudoku2);
		solver.print();
		
		System.out.println();
		
		System.out.println(solver.solve());
		
		solver.print();
	}

}
