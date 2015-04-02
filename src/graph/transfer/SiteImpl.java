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

	/**
	 * neighbours list of neighbours
	 * msg the message which is send
	 */
	private static final long serialVersionUID = -7527243865828709621L;
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
	public boolean receive(byte[] msg) throws RemoteException {
		
		String test = new String (msg);
		
		// if the graph is a cycle 
		if(!test.equals(this.msg)){
			
			this.msg = new String (msg);
			System.out.println("Message reçu : " + this.msg);
			return this.sendToNeighbours();
			
		}
		return true;
	}

	/**
	 *  Send the message to all neighbours.
	 *  @throws RemoteException
	 */
	public boolean sendToNeighbours() throws RemoteException {
		
		if(this.neighbours.size() > 0){
			for(SiteItf s : this.neighbours){
				s.receive(this.msg.getBytes());
			}	
		}
		return true;
	}
	
	
	/**
	 *  Return all neighbours.
	 *  @throws RemoteException
	 */
	public List<SiteItf> getNeighbours(){
		
		return this.neighbours;
		
	}

		/**
	 * Return the message
	 * @return the message of the RMIObject
	 * @throws RemoteException
	 */
	public String getMsg()throws RemoteException {
		
		return this.msg;
	}

}
