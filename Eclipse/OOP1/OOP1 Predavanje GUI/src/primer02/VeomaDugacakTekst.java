package primer02;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

public class VeomaDugacakTekst extends JFrame {

	private static final long serialVersionUID = 1741297790734727886L;
	
	public VeomaDugacakTekst() {
		setSize(416, 266);
		setLocation(300, 300);
		setTitle("Veoma dugacak tekst");
		
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.RIGHT);
		flow.setHgap(10);
		getContentPane().setLayout(flow);
		
		getContentPane().add(new JButton("Button1"));
		getContentPane().add(new JButton("Button2"));
		getContentPane().add(new JButton("Button3"));
		getContentPane().add(Box.createHorizontalStrut(100));
		getContentPane().add(new JButton("Dugacak tekst"));
		getContentPane().add(new JButton("Veoma dugacak tekst"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new VeomaDugacakTekst();
	}

}
