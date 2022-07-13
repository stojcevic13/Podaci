package zadatak1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1345647468641852575L;
	
	JPanel content = (JPanel) getContentPane();

	public MainFrame() {
		setTitle("Prozor1");
		setSize(300, 300);
		setLocation(300, 300);
		
		this.addWindowListener(new CloseWindow());
		postaviDugmice();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	public class CloseWindow extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			int odg = JOptionPane.showConfirmDialog(MainFrame.this, "Da li ste sigurni da zelite da izadjete?",
					"Potvrda izlaska", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (odg == JOptionPane.YES_OPTION)
				System.exit(0);
		}
	}
	
	private void postaviDugmice() {
		JPanel panel1 = new JPanel();
		JButton btnOk = new JButton("Ok");
		JButton btnCancel = new JButton("Cancel");
		panel1.add(btnOk);
		btnOk.addActionListener(new OtvaranjeDrugogProzora());

		panel1.add(Box.createHorizontalStrut(30));
		panel1.add(btnCancel);
		content.add(panel1, BorderLayout.SOUTH);
	}

	
	public class OtvaranjeDrugogProzora implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame prozor2 = new MainFrame();
			prozor2.setTitle("Prozor2");
			prozor2.setSize(400, 400);
			prozor2.setLocation(200, 200);
			prozor2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			prozor2.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					prozor2.setVisible(false);
				}
			});
			prozor2.setVisible(true);
		}
		
	}
	
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
