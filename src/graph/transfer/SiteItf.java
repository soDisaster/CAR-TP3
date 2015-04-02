package graph.transfer;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * RMI Object Interface
 * @author Anne-Sophie Saint-Omer & Thibault Rosa
 */

public interface SiteItf extends Remote {

	/**
	 *  Add a neighbour to an element
	 *  @throws RemoteException
	 */
	void addNeighbour(SiteItf s) throws RemoteException;
	
	/**
	 * The RMI object receive a message.
	 * @param msg Message which receive by the RMI object
	 * @throws RemoteException
	 */
	boolean receive(byte[] msg) throws RemoteException;
	
	/**
	 *  Send the message to all neighbours.
	 *  @throws RemoteException
	 */
	boolean sendToNeighbours() throws RemoteException;
	
	/**
	 * Return the message
	 * @return the message of the RMIObject
	 * @throws RemoteException
	 */
	String getMsg()throws RemoteException;
	
}
