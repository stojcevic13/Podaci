package primjer3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrameVel extends JFrame {

	private JButton dugme = new JButton("dugme");
	private Toolkit kit = Toolkit.getDefaultToolkit();
	
	public MainFrameVel() {
		setTitle("Primjer3 - Velicina");
		setSize(400, 280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400, 250);
		setVisible(true);
		getContentPane().add(dugme, BorderLayout.NORTH);
		
		Dimension rezolucija = kit.getScreenSize();
		System.out.println(rezolucija.width + " x " + rezolucija.height);
		
		Image slika = kit.getImage("slika.jpg");
		setIconImage(slika);		
		
		
	}
	
	public static void main(String[] args) {
		
		MainFrameVel app = new MainFrameVel();
		
	}

}
