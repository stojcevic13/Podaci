package primer11;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class TestGasenje extends JFrame {
	public TestGasenje() {
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int answer = JOptionPane.showConfirmDialog(TestGasenje.this, "Da li zelite da izadjete?", "Naslov", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (answer == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		
		JButton btnNewButton = new JButton("IZLAZ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null, "Da li zelite da izadjete iz aplikacije?", "Naslov", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (answer == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		setSize(300, 400);
		setVisible(true);
	}


	private static final long serialVersionUID = -8430620124405630656L;

	
	
	public static void main(String[] args) {
		new TestGasenje();

	}

}
