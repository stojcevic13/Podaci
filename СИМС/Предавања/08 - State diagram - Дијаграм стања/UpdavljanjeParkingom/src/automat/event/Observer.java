package automat.event;

import java.util.EventListener;

/**
 * Observer interfejs treba da implementiraju svi koji zele da se registruju za pracenje promena podataka u okviru kontrolera parkinga:
 */
public interface Observer {
	public void updatePerformed(UpdateEvent e);
}