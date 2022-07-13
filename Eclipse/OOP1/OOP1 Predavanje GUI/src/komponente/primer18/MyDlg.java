package komponente.primer18;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class MyDlg extends JDialog {

	private static final long serialVersionUID = -5433259326370372576L;

	public MyDlg(JFrame parent) {
		super(parent, "Naslov dijaloga", true);
		setSize(300, 200);
		getContentPane().setLayout(new FlowLayout());
	}
	
}
