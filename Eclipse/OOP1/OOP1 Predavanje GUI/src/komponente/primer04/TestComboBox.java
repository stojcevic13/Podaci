package komponente.primer04;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestComboBox extends JFrame {

	private static final long serialVersionUID = 4425102717939195416L;

	public TestComboBox() {
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.CENTER);
		setLayout(flow);
		
		JComboBox<String> combo = new JComboBox<String>();
		String[] items = {"Opcija1", "Opcija2", "Opcija3", "Opcija4"};
		for (String item : items)
			combo.addItem(item);
		
		JLabel l = new JLabel();
		l.setText("Odabrano je: " + combo.getSelectedItem());
		
		combo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				l.setText("Odabrano je: " + combo.getSelectedItem());
				System.out.println(combo.getSelectedItem());
			}
		});
		
		Container content = getContentPane();
		content.add(combo);
		content.add(l);
		
		
		setSize(300, 300);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestComboBox();
	}

}
