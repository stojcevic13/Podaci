package komponente.primer01;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKeyReleased extends JFrame {

	private static final long serialVersionUID = 8019040556417666229L;
	private JTextField txt;
	private JTextField textField;

	public TestKeyReleased() {
		

		
		setSize(447, 339);
		setLocation(300, 300);
		setTitle("Naslov");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		getContentPane().add(textField);
		textField.setColumns(40);
		class Reakcija extends KeyAdapter {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A)
					lblNewLabel.setText("Pritisnuo taster A");
				else
					lblNewLabel.setText("Tekst: ");
			}
		}
		textField.addKeyListener(new Reakcija());
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestKeyReleased();
	}
}
