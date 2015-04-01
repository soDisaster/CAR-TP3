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
	private List<SiteItf> neighbours;
	private String msg;
	
	
	/**
	 * Constructor without parameters
	 * @throws RemoteException
	 */
	public SiteImpl() throws RemoteException {
		super();
		this.neighbours = new ArrayList<SiteItf>();
	}
	
	/**
	 * **
	 * Constructor with parameters
	 * @param n neighbours
	 * @throws RemoteException
	 */
	public SiteImpl(SiteItf f, List<SiteItf> n) throws RemoteException {
		super();
		this.neighbours = n;
	}
		
	/**
	 *  Set sons of RMIObject.
	 *  @param List of sons 
	 *  @throws RemoteException
	 */
	public void setNeighbours(List<SiteItf> f) throws RemoteException {
		this.neighbours = f;
	}

	/**
	 *  Add a neighbour to an element
	 *  @throws RemoteException
	 */
	public void addNeighbour(SiteItf s) throws RemoteException {
		this.neighbours.add(s);
	}
	
	/**
	 * The RMI object receive a message.
	 * @param msg Message which receive by the RMI object
	 * @throws RemoteException
	 */
	public boolean receive(String msg) throws RemoteException {
		this.msg = msg;
		System.out.println(this.msg);
		return this.sendToNeighbours();
	}

	/**
	 *  Send the message to all neighbours.
	 *  @throws RemoteException
	 */
	public boolean sendToNeighbours() throws RemoteException {
		if(neighbours.size() > 0){
			for(SiteItf s : neighbours){
				s.receive(this.msg);
			}	
		}
		return true;
	}

}
