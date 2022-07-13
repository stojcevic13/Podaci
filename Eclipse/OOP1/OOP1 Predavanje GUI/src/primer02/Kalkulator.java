package primer02;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Kalkulator extends JFrame {

	private static final long serialVersionUID = -3468801253085454221L;

	public Kalkulator() {
		
		setSize(352, 418);
		setLocation(350, 200);
		setTitle("Kalkulator");
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("0");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 4, 5, 5));
		
		JButton btnNewButton = new JButton("1");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("/");
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("4");
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5");
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("*");
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("7");
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("8");
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("9");
		panel_1.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("+");
		panel_1.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("0");
		panel_1.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton(".");
		panel_1.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("=");
		panel_1.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("-");
		panel_1.add(btnNewButton_15);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Kalkulator();

	}

}
