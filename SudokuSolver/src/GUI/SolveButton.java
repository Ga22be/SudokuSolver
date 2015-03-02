package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SolveButton extends JButton implements ActionListener{
	private SudokuGUI gui;
	
	public SolveButton(SudokuGUI gui){
		super("Solve");
		this.gui = gui;
		addActionListener(this);
		this.setToolTipText("Solves the sudoku");
		
	}
	
	public void actionPerformed(ActionEvent e){
		int[][] table = gui.to2DArray();
		gui.getSolver().newPuzzle(table);
		if(!gui.getSolver().solve()){
			gui.failedMessage();
			return;
		}
		gui.fillPuzzle(table);
	}

}
