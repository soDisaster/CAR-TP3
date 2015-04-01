package graph.transfer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * RMI Object
 * @author Anne-Sophie Saint-Omer & Thibault Rosa
 */

public class SiteImpl extends UnicastRemoteObject implements SiteItf {

	private SiteItf father;
	private List<SiteItf> sons;
	private String msg;
	
	
	/**
	 * Constructor without parameters
	 * @throws RemoteException
	 */
	public SiteImpl() throws RemoteException {
		super();
		this.sons = new ArrayList<SiteItf>();
	}
	
	/**
	 * **
	 * Constructor with parameters
	 * @param f father
	 * @param s sons
	 * @throws RemoteException
	 */
	public SiteImpl(SiteItf f, List<SiteItf> s) throws RemoteException {
		super();
		this.father = f;
		this.sons = s;
	}
	
	/**
	 *  The RMIObject is root or not.
	 *  @throws RemoteException
	 */
	public boolean isRoot() throws RemoteException {
		return this.father == null;
	}
	
	/**
	 *  Set father of RMIObject.
	 *  @param New father of RMIObject
	 *  @throws RemoteException
	 */
	public void setFather(SiteItf f) throws RemoteException {
		this.father = f;
	}
	
	/**
	 *  Set sons of RMIObject.
	 *  @param List of sons 
	 *  @throws RemoteException
	 */
	public void setSons(List<SiteItf> f) throws RemoteException {
		this.sons = f;
	}

	/**
	 *  Add a son to an element
	 *  @throws RemoteException
	 */
	public void addSon(SiteItf s) throws RemoteException {
		this.sons.add(s);
	}
	
	/**
	 * The RMI object receive a message.
	 * @param msg Message which receive by the RMI object
	 * @throws RemoteException
	 */
	public boolean receive(String msg) throws RemoteException {
		this.msg = msg;
		System.out.println(this.msg);
		return this.sendToSons();
	}

	/**
	 *  Send the message to all the sons.
	 *  @throws RemoteException
	 */
	public boolean sendToSons() throws RemoteException {
		if(sons.size() > 0){
			for(SiteItf s : sons ){
				s.receive(this.msg);
			}	
		}

		return true;
	}

}
