package primer06;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestActionListener extends JFrame {

	private static final long serialVersionUID = 1530998584343051962L;

	public TestActionListener() {
		setTitle("Test1");
		setSize(300, 400);
		setLocation(300, 300);
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplikacija ce se ugasiti", "Upozorenje", JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		});
		getContentPane().add(btnIzlaz, BorderLayout.NORTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new TestActionListener();

	}

}
