package primer02;

import java.awt.BorderLayout;
//import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;


public class TestFlowLayout extends JFrame {

	private static final long serialVersionUID = -7364365270052390320L;



	public TestFlowLayout() {
			setSize(489, 324);
			setLocation(500, 250);
			setTitle("FlowLayout");
			
			FlowLayout flow = new FlowLayout();
			flow.setAlignment(FlowLayout.RIGHT);
			JPanel p = new JPanel();
			p.setLayout(flow);
			p.add(new JButton("OK"));
			p.add(new JButton("Cancel"));
			//p.setPreferredSize(new Dimension(100, 80));
			
			getContentPane().add(p, BorderLayout.SOUTH);
			
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setHgap(15);
			flowLayout.setVgap(15);
			flowLayout.setAlignment(FlowLayout.LEFT);
			getContentPane().add(panel, BorderLayout.NORTH);
			
			JLabel lblNewLabel = new JLabel("Prva labela");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Druga labela");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("3");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("4");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel.add(lblNewLabel_3);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
	}

	

	public static void main(String[] args) {

		new TestFlowLayout();

	}

}
