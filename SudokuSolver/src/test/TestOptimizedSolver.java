package test;

import java.util.LinkedList;

import solver.OptimizedSolver;
import solver.Solver;

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
		
//		Solves
		int[][] sudoku3 = {
			{ 0, 2, 0, 0, 0, 0, 6, 5, 0 },
			{ 6, 0, 0, 4, 3, 0, 0, 0, 8 }, 
			{ 7, 0, 9, 0, 0, 2, 1, 0, 0 },
			{ 0, 0, 4, 8, 7, 5, 0, 9, 0 }, 
			{ 0, 3, 0, 1, 0, 9, 0, 8, 0 },
			{ 0, 9, 0, 2, 4, 3, 7, 0, 0 }, 
			{ 0, 0, 8, 3, 0, 0, 2, 0, 1 },
			{ 9, 0, 0, 0, 8, 1, 0, 0, 3 }, 
			{ 0, 1, 6, 0, 0, 0, 0, 7, 0 }
		};
		
		int[][] sudoku4 = { 
			{ 0, 0, 0, 0, 0, 7, 0, 0, 0 },
			{ 8, 6, 0, 0, 5, 0, 0, 0, 0 }, 
			{ 4, 3, 5, 0, 0, 8, 0, 1, 0 },
			{ 0, 0, 0, 6, 0, 0, 0, 0, 3 }, 
			{ 0, 1, 4, 0, 0, 0, 5, 8, 0 },
			{ 3, 0, 0, 0, 0, 2, 0, 0, 0 }, 
			{ 0, 2, 0, 9, 0, 0, 6, 5, 8 },
			{ 0, 0, 0, 0, 3, 0, 0, 2, 7 }, 
			{ 0, 0, 0, 5, 0, 0, 0, 0, 0 }
		};
		
		OptimizedSolver optSolver = new OptimizedSolver();
		optSolver.newPuzzle(sudoku2.clone());
//		optSolver.print();
		System.out.println();

		Solver stSolver = new Solver();
		stSolver.newPuzzle(sudoku2.clone());
				
		long start = System.currentTimeMillis();
		System.out.println(optSolver.solve());
		long end = System.currentTimeMillis();
		long optimized = end - start;

		start = System.currentTimeMillis();
		System.out.println(stSolver.solve());
		end = System.currentTimeMillis();
		long standard = end - start;
				
		optSolver.print();
		System.out.println();
		stSolver.print();
		
		System.out.println("Optimized time: " + optimized + "ms");
		System.out.println("Standard time: " + standard + "ms");
		
	}

}
