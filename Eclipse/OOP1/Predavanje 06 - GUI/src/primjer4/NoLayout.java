package primjer4;

import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NoLayout extends JFrame {
	
	private static final long serialVersionUID = -58085330986280581L;
	
	private JButton ok = new JButton("OK");
	
	public NoLayout() {
		setTitle("No Layout");
		setSize(640, 480);
		setLocation(new Point(300, 200));
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(ok);
		ok.setBounds(100, 100, 60, 30);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new NoLayout();
	}

}
