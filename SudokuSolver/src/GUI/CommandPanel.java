package GUI;

import java.awt.*;

import javax.swing.*;

public class CommandPanel extends JPanel {
	public CommandPanel(SudokuGUI gui) {
		setLayout(new FlowLayout());
		add(new ClearButton(gui));
		add(new SolveButton(gui));
	}
}
