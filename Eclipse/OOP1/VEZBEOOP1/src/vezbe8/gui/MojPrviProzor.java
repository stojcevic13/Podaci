package vezbe8.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MojPrviProzor extends JFrame {

	// sva inicijalizacija se vrsi u konstruktoru
	public MojPrviProzor() {
		// naslov prozora
		setTitle("Moj prvi Swing prozor");
		// sirina i visina prozora u pikselima
//		setSize(500, 500);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/2, screenHeight/4);
		
		/*
		 * Centrira prozor u odnosu na prosledjenu komponentu. Ako se prosledi null,
		 * prozor se centrira na sredini ekrana. Ako se ne pozove ova funkcija, prozor
		 * se prikazuje u gornjem levom uglu ekrana.
		 */
		setLocationRelativeTo(null);
		/*
		 * Specificira kako ce se prozor ponasati kada se zatvori (klik na dugme X).
		 * Opcije: 
		 * 		- DISPOSE_ON_CLOSE: Zatvara prozor i oslobadja zauzete memorijske
		 * 				resurse. Ako je ovo bio jedini otvoreni prozor u programu, program se
		 * 				prekida.
		 * 		- EXIT_ON_CLOSE: Zatvara prozor i prekida program.
		 * 		- HIDE_ON_CLOSE: Samo vizuelno sakriva prozor.
		 * 		- DO_NOTHING_ON_CLOSE: Dugme za zatvaranje prozora ne radi nista, ocekuje se od
		 * 				korisnika da napise reakciju na klik na ovo dugme.
		 */
//		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setResizable(false);
		
		JButton btnOk = new JButton("OK");
		add(btnOk, BorderLayout.SOUTH);
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("KLIK!");				
			}
		});
		
		
		JTextField txtProba = new JTextField();
		
//		txtProba.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		txtProba.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A) {
					System.out.println("Pritisnuto slovo 'a'.");
				}				
			}
		});
		
		add(txtProba, BorderLayout.NORTH);
		
	}
}
