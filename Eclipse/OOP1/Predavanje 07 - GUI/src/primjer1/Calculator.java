package primjer1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Calculator extends JFrame {

	private static final long serialVersionUID = -2005303838592061411L;
	
	private JLabel display;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private boolean start;
	
	
	private void addButton(String label, ActionListener listener) {
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	
	public Calculator() {
		setTitle("Calculator");
		setSize(new Dimension(500, 500));
		setLocation(300, 300);
		
		result = 0;
		lastCommand = "=";
		start = true;
		
		display = new JLabel("0");
		display.setPreferredSize(new Dimension(50, 50));
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setEnabled(true);
		add(display, BorderLayout.NORTH);
		
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		
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
		
		add(panel, BorderLayout.CENTER);
		
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	private class InsertAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String input = e.getActionCommand();
			if (start) {
				display.setText("");
				start = false;
			}
			display.setText(display.getText() + input);
		}
	}
	
	
	private class CommandAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			if (start) {
				if (command.equals("=")) {
					display.setText(command);
					start = false;
				}
				else
					lastCommand = command;
			}
			else {
				calculate(Double.parseDouble(display.getText()));
				lastCommand = command;
				start = true;
			}
		}
	}
	
	
	public void calculate(double x) {
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



