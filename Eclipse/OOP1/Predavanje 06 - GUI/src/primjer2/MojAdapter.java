package primjer2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MojAdapter extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
