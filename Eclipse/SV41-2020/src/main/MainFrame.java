package main;

import javax.swing.JDialog;
import javax.swing.JFrame;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1453023172562886029L;
	
	public static JDialog prijavaDlg;

	public MainFrame() {
		new Podaci();
		loginDialog();
	}
	
	private void loginDialog() {
		prijavaDlg = new PrijavaDlg();
		prijavaDlg.setLocationRelativeTo(null);
		prijavaDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		prijavaDlg.setResizable(false);
		prijavaDlg.setVisible(true);
	}
	

	public static void main(String[] args) {
		new MainFrame();
	}

}
