package primjer5;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderFrame extends JFrame {
	
	private static final long serialVersionUID = -7380403895175440763L;
	
	private JButton istok = new JButton("Istok");
	private JButton zapad = new JButton("Zapad");
	private JButton sever = new JButton("Sever");
	private JButton jug = new JButton("Jug");
	private JButton centar = new JButton("Centar");
	
	public BorderFrame() {
		BorderLayout b = new BorderLayout();
		b.setHgap(3);
		b.setVgap(3);
		setTitle("Border Layout");
		setLayout(b);
		setSize(500, 300);
		setLocation(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sever.setPreferredSize(new Dimension(30, 50));
		getContentPane().add(istok, b.EAST);
		getContentPane().add(zapad, b.WEST);
		getContentPane().add(sever, b.NORTH);
		getContentPane().add(jug, b.SOUTH);
		getContentPane().add(centar, b.CENTER);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {

		new BorderFrame();
	}

}
