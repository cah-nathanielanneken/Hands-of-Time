import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 700;
	private JLabel position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, position12, position13;
	private JTextField pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9, pos10, pos11, pos12, pos13, solution;
	private JButton findAnswer, clear, exitB;
	// Button handlers:
	private CalculateButtonHandler solverHandler;
	private ExitButtonHandler ebHandler;
	private clearButtonHandler cbHandler;

	public GUI() {
		position1 = new JLabel("Position 1: ", SwingConstants.RIGHT);
		position2 = new JLabel("Position 2: ", SwingConstants.RIGHT);
		position3 = new JLabel("Position 3: ", SwingConstants.RIGHT);
		position4 = new JLabel("Position 4: ", SwingConstants.RIGHT);
		position5 = new JLabel("Position 5: ", SwingConstants.RIGHT);
		position6 = new JLabel("Position 6: ", SwingConstants.RIGHT);
		position7 = new JLabel("Position 7: ", SwingConstants.RIGHT);
		position8 = new JLabel("Position 8: ", SwingConstants.RIGHT);
		position9 = new JLabel("Position 9: ", SwingConstants.RIGHT);
		position10 = new JLabel("Position 10: ", SwingConstants.RIGHT);
		position11 = new JLabel("Position 11: ", SwingConstants.RIGHT);
		position12 = new JLabel("Position 12: ", SwingConstants.RIGHT);
		position13 = new JLabel("Position 13: ", SwingConstants.RIGHT);
		position1.setForeground(Color.white);
		position2.setForeground(Color.white);
		position3.setForeground(Color.white);
		position4.setForeground(Color.white);
		position5.setForeground(Color.white);
		position6.setForeground(Color.white);
		position7.setForeground(Color.white);
		position8.setForeground(Color.white);
		position9.setForeground(Color.white);
		position10.setForeground(Color.white);
		position11.setForeground(Color.white);
		position12.setForeground(Color.white);
		position13.setForeground(Color.white);
		Font font = new Font("Verdana", Font.BOLD, 12);
		position1.setFont(font);
		position2.setFont(font);
		position3.setFont(font);
		position4.setFont(font);
		position5.setFont(font);
		position6.setFont(font);
		position7.setFont(font);
		position8.setFont(font);
		position9.setFont(font);
		position10.setFont(font);
		position11.setFont(font);
		position12.setFont(font);
		position13.setFont(font);

		pos1 = new JTextField(2);
		pos2 = new JTextField(2);
		pos3 = new JTextField(2);
		pos4 = new JTextField(2);
		pos5 = new JTextField(2);
		pos6 = new JTextField(2);
		pos7 = new JTextField(2);
		pos8 = new JTextField(2);
		pos9 = new JTextField(2);
		pos10 = new JTextField(2);
		pos11 = new JTextField(2);
		pos12 = new JTextField(2);
		pos13 = new JTextField(2);
		solution = new JTextField(35);

		// SPecify handlers for each button and add (register) ActionListeners
		// to each button.
		findAnswer = new JButton("Solve");
		findAnswer.setFont(new Font("Veranda", Font.BOLD, 15));
		solverHandler = new CalculateButtonHandler();
		findAnswer.addActionListener(solverHandler);
		clear = new JButton("Clear");
		clear.setFont(new Font("Veranda", Font.BOLD, 15));
		cbHandler = new clearButtonHandler();
		clear.addActionListener(cbHandler);
		exitB = new JButton("Exit");
		exitB.setFont(new Font("Veranda", Font.BOLD, 15));
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);

		setTitle("Hands of Time Puzzle Solver");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(15, 2));
		// Add things to the pane in the order you want them to appear (left to
		// right, top to bottom)
		pane.add(position1);
		pane.add(pos1);
		pane.add(position2);
		pane.add(pos2);
		pane.add(position3);
		pane.add(pos3);
		pane.add(position4);
		pane.add(pos4);
		pane.add(position5);
		pane.add(pos5);
		pane.add(position6);
		pane.add(pos6);
		pane.add(position7);
		pane.add(pos7);
		pane.add(position8);
		pane.add(pos8);
		pane.add(position9);
		pane.add(pos9);
		pane.add(position10);
		pane.add(pos10);
		pane.add(position11);
		pane.add(pos11);
		pane.add(position12);
		pane.add(pos12);
		pane.add(position13);
		pane.add(pos13);
		pane.add(findAnswer);
		pane.add(solution);
		pane.add(clear);
		pane.add(exitB);

		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class CalculateButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] a = new String[13];
			a[0] = (pos1.getText()).trim();
			a[1] = (pos2.getText()).trim();
			a[2] = (pos3.getText()).trim();
			a[3] = (pos4.getText()).trim();
			a[4] = (pos5.getText()).trim();
			a[5] = (pos6.getText()).trim();
			a[6] = (pos7.getText()).trim();
			a[7] = (pos8.getText()).trim();
			a[8] = (pos9.getText()).trim();
			a[9] = (pos10.getText()).trim();
			a[10] = (pos11.getText()).trim();
			a[11] = (pos12.getText()).trim();
			a[12] = (pos13.getText()).trim();
			int size=0;
			for(int y=0; y<13; y++) {
				if(!a[y].equals(""))
					size++;
			}

			int[] b = new int[size];
			for(int x=0; x<size; x++) {
				b[x] = Integer.parseInt(a[x]);
			}

			ArrayList<Clock> list = new ArrayList<Clock>();
			Solver s = new Solver(b, size);
			list = s.Solution();
			if(s.Solution().size()==0) {
				solution.setText("No solution");
			}
			else
				solution.setText("Position Order: "+list.get(0).toString());
		}
	}

	public class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public class clearButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pos1.setText("");
			pos2.setText("");
			pos3.setText("");
			pos4.setText("");
			pos5.setText("");
			pos6.setText("");
			pos7.setText("");
			pos8.setText("");
			pos9.setText("");
			pos10.setText("");
			pos11.setText("");
			pos12.setText("");
			pos13.setText("");
			solution.setText("");
		}
	}
	public static void main(String[] args) {
		GUI rectObj = new GUI();
		rectObj.getContentPane().setBackground(Color.black);
	}
}
