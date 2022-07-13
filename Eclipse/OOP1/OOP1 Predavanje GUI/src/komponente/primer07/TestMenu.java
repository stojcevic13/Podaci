package komponente.primer07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class TestMenu extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 5705576321083435471L;
	
	JMenuBar menuBar;
	JMenu menu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    JPopupMenu popup;

	public TestMenu() {
		setSize(300, 300);
		setTitle("JMenu Test");
		setLocation(300, 300);
		
		menuBar = new JMenuBar();
		
		menu = new JMenu("File");
		menuBar.add(menu);
		menu.setMnemonic(KeyEvent.VK_F);   // aktivira se na: alt + F
		
		menuItem = new JMenuItem("Open", KeyEvent.VK_O);   // alt + F + O
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));   // aktivira se na ctrl+O i to se dodaje u opis
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("Ukljuci radio 1");
		rbMenuItem.setSelected(false);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);  // aktivira se na alt+F+R
		group.add(rbMenuItem);
		rbMenuItem.addItemListener(this);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("Ukljuci radio 2");
		rbMenuItem.setSelected(false);
		rbMenuItem.setMnemonic(KeyEvent.VK_T);  // aktivira se na alt+F+T
		group.add(rbMenuItem);
		rbMenuItem.addItemListener(this);
		menu.add(rbMenuItem);
		
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("Ukljuci checkBox");
		cbMenuItem.setSelected(false);
		cbMenuItem.setMnemonic(KeyEvent.VK_C);  // alt+F+C
		cbMenuItem.addItemListener(this);
		menu.add(cbMenuItem);
		
		menu.addSeparator();
		menuItem = new JMenuItem("Izlaz");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));  // alt+F4
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		
		// popup menu
		
		popup = new JPopupMenu();
		menuItem = new JMenuItem("Stavka1");
		menuItem.addActionListener(this);
		popup.add(menuItem);
		
		menuItem = new JMenuItem("Stavka2");
		menuItem.addActionListener(this);
		popup.add(menuItem);
		
		menuItem = new JMenuItem("Stavka3");
		menuItem.addActionListener(this);
		popup.add(menuItem);
		
		MouseListener popupListener = new PopupListener(popup);
		this.addMouseListener(popupListener);
		
		setJMenuBar(menuBar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		JMenuItem source = (JMenuItem) (e.getSource());
		String s = source.getText();
		System.out.println("Item event se dogodio: " + s + ". Stanje: " + 
				((source.isSelected() == true) ? "selected" : "unselected"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) (e.getSource());
		String s = source.getText();
		System.out.println("Opcija menija: " + s);
		if (s.equals("Izlaz"))
			System.exit(0);
	}
	
	
	class PopupListener extends MouseAdapter {
		JPopupMenu popup1;
		
		PopupListener(JPopupMenu popupMenu){
			popup1 = popupMenu;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			maybeShowPopup(e);
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			maybeShowPopup(e);
		}

		private void maybeShowPopup(MouseEvent e) {
			if (e.isPopupTrigger())
				popup1.show(e.getComponent(), e.getX(), e.getY());
		}
			
	}
	
	
	
	public static void main(String[] args) {
		new TestMenu();
	}



}
