package transfer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface RMI
 * @author Anne-Sophie Saint-Omer & Thibault Rosa
 */

public interface SiteItf extends Remote {

	void deposer(int i) throws RemoteException;
	char[] solde() throws RemoteException;
	int add(int i, int j) throws RemoteException;
	
}
