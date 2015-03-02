package application;

import GUI.SudokuGUI;
import solver.Solver;

public class SudokuSolver {

	public static void main(String[] args) {
		Solver solver = new Solver();
		new SudokuGUI(solver);
	}

}
