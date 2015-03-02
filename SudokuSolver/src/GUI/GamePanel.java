package GUI;

import javax.swing.*;

import java.awt.*;

public class GamePanel extends JPanel {
	public GamePanel(SudokuGUI gui) {
		setLayout(new GridLayout(9, 9));
	}
}
