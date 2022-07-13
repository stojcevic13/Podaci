package predavanje01gui;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class TestUvod extends JFrame{
	
	private static final long serialVersionUID = 8998369982079011775L;
	
	Toolkit kit = Toolkit.getDefaultToolkit();

	public TestUvod(){
		setSize(300, 200);
		setLocation(400, 400);
		setTitle("GUI Uvod");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Image slika = kit.getImage("slika.jpg");
		setIconImage(slika);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new TestUvod();

	}

}
