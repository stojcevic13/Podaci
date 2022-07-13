package komponente.primer06;

import java.awt.Button;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

public class TestTabbedPane extends JFrame {

	private static final long serialVersionUID = 2989078030828339780L;

	public TestTabbedPane() {
		setSize(300, 300);
		setTitle("TestTabbedPane");
		setLocation(300, 300);
		JTabbedPane tab = new JTabbedPane();
		
		JComponent panel1 = new JPanel();
		panel1.add(new JLabel("labela1"));
		panel1.add(new Button("Dugme1"));
		tab.addTab("Tab1", null, panel1, "tab1");
		
		JComponent panel2 = new JPanel();
		panel2.add(new JLabel("labela2"));
		JRadioButton radio1 = new JRadioButton("Radio1", false);
		JRadioButton radio2 = new JRadioButton("Radio2", false);
		JRadioButton radio3 = new JRadioButton("Radio3", false);
		panel2.add(radio1);
		panel2.add(radio2);
		panel2.add(radio3);
		ButtonGroup grupa = new ButtonGroup();
		grupa.add(radio1);
		grupa.add(radio2);
		grupa.add(radio3);
		
		tab.addTab("Tab2", null, panel2, "tab2");
		
		getContentPane().add(tab);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestTabbedPane();
	}

}
