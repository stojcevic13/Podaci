package primjer6;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiksFrame extends JFrame {

	private static final long serialVersionUID = 4683278001622002171L;
	
	public MiksFrame() {
		setTitle("Miks Frame");
		setSize(400, 250);
		setLocation(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.RIGHT);
		flow.setHgap(10);
		
		JPanel panel = new JPanel();
		panel.setLayout(flow);
		panel.add(new JButton("Ok"));
		panel.add(new JButton("Cancel"));
		
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		getContentPane().add(btnNewButton, BorderLayout.CENTER);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new MiksFrame();
	}

}
