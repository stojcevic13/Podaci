package primjer2;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagFrame2 extends JFrame {

	private static final long serialVersionUID = 6190224642204387041L;
	
	private JButton button1 = new JButton("Button1");
	private JButton button2 = new JButton("Button2");
	private JButton button3 = new JButton("Button3");
	private JButton button4 = new JButton("Button4");
	private JButton button5 = new JButton("Button5");
	private GridBagConstraints gbc1 = new GridBagConstraints();
	private GridBagConstraints gbc2 = new GridBagConstraints();
	private GridBagConstraints gbc3 = new GridBagConstraints();
	private GridBagConstraints gbc4 = new GridBagConstraints();
	private GridBagConstraints gbc5 = new GridBagConstraints();
	
	public GridBagFrame2() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		
		Container pane = getContentPane();
		pane.setLayout(gbl);
		
		setTitle("GridBagLayout");
		setSize(400, 250);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//button1
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.fill = GridBagConstraints.NONE;
		gbc1.anchor = GridBagConstraints.CENTER;
		pane.add(button1, gbc1);
		
		//button2
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.weightx = 0.5;
//		gbc2.anchor = GridBagConstraints.CENTER;
		pane.add(button2, gbc2);
		
		//button3
		gbc3.gridx = 2;
		gbc3.gridy = 0;
		gbc3.fill = GridBagConstraints.HORIZONTAL;
//		gbc3.anchor = GridBagConstraints.CENTER;
		gbc3.weightx = 0.5;
		pane.add(button3, gbc3);
		
		//button4
		gbc4.gridx = 0;
		gbc4.gridy = 1;
		gbc4.gridwidth = 3;
		gbc4.fill = GridBagConstraints.HORIZONTAL;
//		gbc4.anchor = GridBagConstraints.CENTER;
		gbc.ipady = 40;
		gbc4.weightx = 0.0;
		pane.add(button4, gbc4);
		
		//button5
		gbc5.gridx = 1;
		gbc5.gridy = 2;
		gbc5.gridwidth = 2;
		gbc5.fill = GridBagConstraints.HORIZONTAL;
		gbc5.anchor = GridBagConstraints.PAGE_END;
		gbc5.ipady = 0;
		gbc5.weighty = 1.0;
		gbc5.insets = new Insets(10, 0, 0, 0);
		pane.add(button5, gbc5);

		setVisible(true);
	}

	public static void main(String[] args) {
		
		new GridBagFrame2();
	}

}
