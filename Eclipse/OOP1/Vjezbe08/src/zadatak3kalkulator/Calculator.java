package zadatak3kalkulator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 3051673110200839792L;

	JPanel content = (JPanel) getContentPane();
	JPanel prostor;
	JLabel display;
	boolean start;
	double result;
	String lastCommand;

	public Calculator() {
		setTitle("Kalkulator");
		setSize(300, 400);
		setLocation(300, 300);

		result = 0;
		lastCommand = "=";
		start = true;

		postaviDisplay();
		postaviDugmice();
		content.add(prostor, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void postaviDisplay() {
		display = new JLabel("0");
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setPreferredSize(new Dimension(50, 50));
		content.add(display, BorderLayout.NORTH);
	}

	private void addButton(String label, ActionListener listener) {
		JButton dugme = new JButton(label);
		dugme.addActionListener(listener);
		prostor.add(dugme);
	}

	private void postaviDugmice() {
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		prostor = new JPanel();
		prostor.setLayout(new GridLayout(4, 4, 2, 2));

		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);

		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("*", command);

		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);

		addButton("0", insert);
		addButton(".", insert);
		addButton("=", command);
		addButton("+", command);
	}

	public class InsertAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// u stringu input će se naći tekst dugmeta
			if (start) {
				display.setText(e.getActionCommand());
				start = false;
			} else {
				display.setText(display.getText() + e.getActionCommand());
			}

		}
	}

	public class CommandAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (!start) {
				calculate(Double.parseDouble(display.getText()));
				start = true;
			}
			lastCommand = command;
		}
	}

	private void calculate(double x) {
		if (lastCommand.equals("+"))
			result += x;
		else if (lastCommand.equals("-"))
			result -= x;
		else if (lastCommand.equals("*"))
			result *= x;
		else if (lastCommand.equals("/"))
			result /= x;
		else if (lastCommand.equals("="))
			result = x;
		display.setText("" + result);
	}

	public static void main(String[] args) {
		new Calculator();
	}

}
