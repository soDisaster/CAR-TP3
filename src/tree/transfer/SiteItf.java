package tree.transfer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * RMI Object Interface
 * @author Anne-Sophie Saint-Omer & Thibault Rosa
 */

public interface SiteItf extends Remote {

	/**
	 *  Add a son to an element
	 *  @throws RemoteException
	 */
	void addSon(SiteItf s) throws RemoteException;
	
	/**
	 * The RMI object receive a message.
	 * @param msg Message which receive by the RMI object
	 * @throws RemoteException
	 */
	boolean receive(String msg) throws RemoteException;
	
	/**
	 *  Send the message to all the sons.
	 *  @throws RemoteException
	 */
	boolean sendToSons() throws RemoteException;
	
	/**
	 *  The RMIObject is root or not.
	 *  @throws RemoteException
	 */
	boolean isRoot() throws RemoteException;
	
	/**
	 * set father of the RMIObject
	 *  @throws RemoteException
	 */
	void setFather(SiteItf s) throws RemoteException;



	

}
