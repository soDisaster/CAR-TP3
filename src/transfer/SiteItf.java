package transfer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface RMI
 * @author Anne-Sophie Saint-Omer & Thibault Rosa
 */

public interface SiteItf extends Remote {

	void deposer(int i) throws RemoteException;
	void solde() throws RemoteException;
}
