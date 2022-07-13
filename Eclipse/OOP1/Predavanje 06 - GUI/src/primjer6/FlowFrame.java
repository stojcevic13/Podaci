package primjer6;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlowFrame extends JFrame {
	
	private static final long serialVersionUID = 5568369882554992904L;
	
	private JButton prvo = new JButton("Prvo");
	private JButton drugo = new JButton("Drugo");
	private JButton trece = new JButton("Trece");
	private JButton dugacakTekst = new JButton("Dugacak tekst");
	private JButton veomaDugacakTekst = new JButton("Veoma dugacak tekst");
	
	public FlowFrame() {
		FlowLayout flow = new FlowLayout();
		flow.setHgap(20);
		flow.setAlignment(FlowLayout.RIGHT);
		setTitle("Flow Layout");
		setSize(413, 300);
		setLocation(300, 200);
		
		getContentPane().setLayout(flow);
		getContentPane().add(prvo);
		getContentPane().add(drugo);
		getContentPane().add(trece);
		getContentPane().add(Box.createHorizontalStrut(100));
		getContentPane().add(dugacakTekst);
		getContentPane().add(veomaDugacakTekst);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new FlowFrame();
	}

}
