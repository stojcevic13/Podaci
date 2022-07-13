package forme.izvjestaji;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

import forme.izvjestaji.chartovi.PieChartStringDouble;

public class ChartFrame extends JFrame {

	private static final long serialVersionUID = -7830070593354670820L;

	

	public ChartFrame() {
		
		setTitle("Naslov");
		setSize(300, 300);
		JButton btnDugme = new JButton("Dugme");
		btnDugme.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Map<String, Double> mapa = new HashMap<String, Double>();
				mapa.put("engleski", 12.0);
				mapa.put("svedski", 14.0);
				mapa.put("kineski", 3.0);
				PieChartStringDouble cart = new PieChartStringDouble(mapa);
				cart.prikazi();
			}
		});
		getContentPane().add(btnDugme, BorderLayout.NORTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new ChartFrame();
	}
}
