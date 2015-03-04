package GUI;

import java.awt.*;

import javax.swing.*;

import solver.Solver;

public class SudokuGUI {
	private JPanel gamePanel;
	private Solver solver;
	private JFrame frame;
	private OneDigitField[][] box;
	
	public SudokuGUI(Solver solver) {
		this.solver = solver;
		frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setResizable(false);
		box = new OneDigitField[9][9];

		gamePanel = new GamePanel(this);
		frame.add(gamePanel);
		JPanel buttonField = new CommandPanel(this);
		frame.add(buttonField, BorderLayout.SOUTH);
		
		for(int i = 0; i < 81; i++){
			int x = i % 9;
			int y = i / 9;
			box[y][x] = new OneDigitField();
			if(isColored(i)){
				box[y][x].setBackground(Color.LIGHT_GRAY);
			}
			gamePanel.add(box[y][x]);
		}
		
		
		frame.setVisible(true);
	}
	
	private boolean isColored(int index){
		if((index / 27) % 2 == 0){
			if((index / 9) % 2 == 0){
				if((index / 3) % 2 == 0){
					return true;
				} 					
			} else {
				if((index / 3) % 2 == 1){
					return true;
				}
			}
		} else {
			if((index / 9) % 2 == 0){
				if((index / 3) % 2 == 1){
					return true;
				} 					
			} else {
				if((index / 3) % 2 == 0){
					return true;
				}
			}
		}
		return false;
	}
	
	public int[][] to2DArray(){
		int[][] table = new int[9][9];
		for(int i = 0; i < 81; i++){
			int x = i % 9;
			int y = i / 9;
			if(box[y][x].getText().isEmpty()){
				table[y][x] = 0;
			} else {
				table[y][x] = new Integer(box[y][x].getText());
			}
		}
		return table;
	}
	
	public void clearPuzzle(){
		for(int i = 0; i < 81; i++){
			int x = i % 9;
			int y = i / 9;
			box[y][x].setText("");
		}
	}
	
	public void fillPuzzle(int[][] table){
		for(int i = 0; i < 81; i++){
			int x = i % 9;
			int y = i / 9;
			box[y][x].setText(new Integer(table[y][x]).toString()); 
		}
	}
	
	public void repaint(){
		gamePanel.repaint();
	}
	
	public Solver getSolver(){
		return solver;
	}
	
	public void failedMessage(){
		JOptionPane.showMessageDialog(frame, "Puzzle is unsolvable!");
	}

}