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
	boolean receive(byte[] msg) throws RemoteException;
	
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


	/**
	 *  Return the father of the RMI object
	 *  @throws RemoteException
	 */
	SiteItf getFather() throws RemoteException;

	
	/**
	 *  Set sons of RMIObject.
	 *  @param List of sons 
	 *  @throws RemoteException
	 */
	void setSons(List<SiteItf> l) throws RemoteException;

	/**
	 *  Return list of sons of the RMI object
	 *  @throws RemoteException
	 */
	List<SiteItf> getSons()throws RemoteException;

	/**
	 * Return the message
	 * @return the message of the RMIObject
	 * @throws RemoteException
	 */
	String getMsg() throws RemoteException;
	
	

	

}
