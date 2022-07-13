package komponente;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestCheckRadio extends JFrame {
	
	private ButtonGroup group = new ButtonGroup();
	JCheckBox chckbxNewCheckBox = new JCheckBox("1");
	JRadioButton rdbtnNewRadioButton = new JRadioButton("r1", true);
	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("r2", false);
	JLabel lblNewLabel = new JLabel("Aktiviran: ");
	
	class Reakcija implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			lblNewLabel.setText("Odabrao: " + ((AbstractButton) e.getItem()).getText());
		}
	}
	
	public TestCheckRadio() {
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		getContentPane().add(chckbxNewCheckBox);
		chckbxNewCheckBox.addItemListener(new Reakcija());
		
		getContentPane().add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addItemListener(new Reakcija());
			
		getContentPane().add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addItemListener(new Reakcija());
		
		getContentPane().add(lblNewLabel);
		
		setVisible(true);
		setSize(300, 300);
	}
	

	private static final long serialVersionUID = -1816270165086755484L;

	public static void main(String[] args) {
		new TestCheckRadio();

	}

}
