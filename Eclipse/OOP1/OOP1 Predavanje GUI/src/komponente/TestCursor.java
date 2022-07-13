package komponente;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.TextArea;

public class TestCursor extends JFrame {
	
	public TestCursor() {
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		TextArea textArea = new TextArea();
		textArea.setColumns(30);
		textArea.setRows(8);
		getContentPane().add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setRows(8);
		textArea_1.setColumns(30);
		getContentPane().add(textArea_1);
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
