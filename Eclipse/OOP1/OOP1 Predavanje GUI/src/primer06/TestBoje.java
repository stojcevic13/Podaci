package primer06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestBoje extends JFrame {
	
	private static final long serialVersionUID = 5029024882337860363L;

	public TestBoje() {
		setTitle("Mijenjanje boja");
		setSize(400, 300);
		setLocation(400, 400);
		
		JButton btnNewButton = new JButton("Promijeni boju");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = (int) (Math.random() * 255);
				int g = (int) (Math.random() * 255);
				int b = (int) (Math.random() * 255);
				btnNewButton.setBackground(new Color(r, g, b));
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Izlaz");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplikacija ce se ugasiti", "Izlaz iz aplikacije", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		getContentPane().add(btnNewButton_1, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new TestBoje();

	}

}
