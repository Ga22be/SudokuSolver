package test;

import solver.OptimizedSolver;
import solver.BruteSolver;

public class TestSolver {

	public static void main(String[] args) {
		int[][] sudoku0 = { 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }
			};
		
		int[][] sudoku1 = { 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 5, 5 }
			};
		
		int[][] sudoku2 = { 
				{ 1, 2, 3, 0, 0, 0, 0, 0, 0 },
				{ 4, 5, 6, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 7, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }
			};
		
		int[][] sudoku3 = {
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
		
		int[][] sudoku4 = { 
				{ 0, 0, 8, 0, 0, 9, 0, 6, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 5 }, 
				{ 1, 0, 2, 5, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 1, 0, 0, 9, 0 }, 
				{ 0, 5, 0, 0, 0, 0, 6, 0, 0 },
				{ 6, 0, 0, 0, 0, 0, 0, 2, 8 }, 
				{ 4, 1, 0, 6, 0, 8, 0, 0, 0 },
				{ 8, 6, 0, 0, 3, 0, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 4, 0, 0 }
			};
		
		
			
		OptimizedSolver solver = new OptimizedSolver();	
//		Solver solver = new Solver();
		
		solver.newPuzzle(sudoku1);
		
		solver.print();
		
		System.out.println();
		
		System.out.println(solver.solve());
		
		System.out.println();
		
		solver.print();
	}

}
