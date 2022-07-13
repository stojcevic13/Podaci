import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class MLayout extends JFrame {

	private static final long serialVersionUID = -3290969901609398557L;
	
	public MLayout() {
		setTitle("Naslov");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel dugmad = new JPanel();
		
		MigLayout mig = new MigLayout();
		dugmad.setLayout(mig);
		
		JButton dugme1 = new JButton("Dugme 1");
		dugmad.add(dugme1, "push, align center");
		
		getContentPane().add(dugmad, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new MLayout();
	}
}
