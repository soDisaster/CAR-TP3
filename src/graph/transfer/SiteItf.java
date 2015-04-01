package graph.transfer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Interface RMI
 * @author Anne-Sophie Saint-Omer & Thibault Rosa
 */

public interface SiteItf extends Remote {

	void addSon(SiteItf s) throws RemoteException;
	boolean receive(String msg) throws RemoteException;
	boolean sendToSons() throws RemoteException;
	boolean isRoot() throws RemoteException;
	void setFather(SiteItf s) throws RemoteException;
}
