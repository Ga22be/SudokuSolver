package application;

import java.lang.reflect.Array;
import java.util.Arrays;

import solver.SolverOld;

public class SudokuSolver {

	public static void main(String[] args) {
		int[][] table = { 
				{ 9, 0, 6, 8, 1, 3, 5, 4, 0 },
				{ 2, 0, 1, 0, 4, 5, 0, 6, 3 }, 
				{ 0, 4, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 6, 2, 0, 0, 0, 9 }, 
				{ 0, 0, 9, 0, 0, 0, 2, 0, 0 },
				{ 7, 0, 0, 0, 3, 4, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 9, 0 },
				{ 5, 9, 0, 3, 6, 0, 1, 0, 4 }, 
				{ 0, 2, 7, 4, 5, 9, 3, 0, 6 } };
		
		System.out.println(Arrays.deepToString(table));

		SolverOld solver = new SolverOld(table);
		System.out.println(solver.solve(0, 0));

	}

}
