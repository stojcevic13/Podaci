package komponente.primer18;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -7563985639316906431L;

	MyDlg dlg = new MyDlg(this);
	
	public MainFrame() {
		setSize(300, 300);
		setTitle("Glavni");
		setLocation(300, 300);
		JButton dugme = new JButton("Aktiviraj modalni dijalog");
		dugme.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(true);
			}
		});
		getContentPane().add(dugme, BorderLayout.NORTH);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
