package chart;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChartFrame extends JFrame {

	private static final long serialVersionUID = 2629782237803259498L;

	public ChartFrame() {
		setTitle("Naslov");
		setSize(300, 300);

		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 
		JButton btnDugme = new JButton("Dugme");
		btnDugme.addActionListener(new Metoda());
		getContentPane().add(btnDugme, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	class Metoda implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new PieChart02();
		}
	}
	
	
	
	public static void main(String[] args) {
		new ChartFrame();
//		new PieChart02();
	}
	
}
