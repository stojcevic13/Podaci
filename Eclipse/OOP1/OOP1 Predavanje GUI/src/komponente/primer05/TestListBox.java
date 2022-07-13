package komponente.primer05;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TestListBox extends JFrame {

	private static final long serialVersionUID = -6462929153874589849L;

	public TestListBox() {
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(FlowLayout.CENTER);
		getContentPane().setLayout(flow);
		Container content = getContentPane();
		JLabel l = new JLabel();
		String[] items = {"Opcija1  ", "Opcija2  ", "Opcija3", "Opcija4", "Opcija5", "Opcija6", "Opcija7", "Opcija8", "Opcija9"};
		
		JList lb = new JList(items);
		lb.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					l.setText("Odabrano je: " + lb.getSelectedValue());
					System.out.println(lb.getSelectedValue());
				}
			}
		});
		JScrollPane scroll = new JScrollPane(lb);
		content.add(scroll);
		
		content.add(l);
		
		setSize(300, 300);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestListBox();
	}

}
