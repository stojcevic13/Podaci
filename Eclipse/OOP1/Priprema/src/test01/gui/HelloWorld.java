package test01.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HelloWorld extends JFrame {

	private static final long serialVersionUID = 5873346342089423482L;
	
	JPanel content = (JPanel) getContentPane();

	public HelloWorld() {
		setTitle("Hello");
		setSize(400, 300);
		setLocation(300, 300);
		
		dodajKomponente();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void dodajKomponente() {
		JLabel labela = new JLabel("Hello, World!");
		labela.setHorizontalAlignment(SwingConstants.CENTER);
		content.add(labela, BorderLayout.CENTER);
		labela.setVisible(false);
		
		JButton button = new JButton("button");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				labela.setVisible(true);
			}
		});
		content.add(button, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new HelloWorld();
	}

}
