package tree.transfer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class SiteImpl extends UnicastRemoteObject implements SiteItf {

	private SiteItf father;
	private List<SiteItf> sons;
	private String msg;
	
	
	public SiteImpl() throws RemoteException {
		super();
		this.sons = new ArrayList<SiteItf>();
	}
	
	public SiteImpl(SiteItf f, List<SiteItf> s) throws RemoteException {
		super();
		this.father = f;
		this.sons = s;
	}
	
	public boolean isRoot() throws RemoteException {
		return this.father == null;
	}
	
	public void setFather(SiteItf f) throws RemoteException {
		this.father = f;
	}
	
	public void setSons(List<SiteItf> f) throws RemoteException {
		this.sons = f;
	}

	public void addSon(SiteItf s) throws RemoteException {
		this.sons.add(s);
	}
	
	public boolean receive(String msg) throws RemoteException {
		this.msg = msg;
		System.out.println(this.msg);
		return this.sendToSons();
	}

	public boolean sendToSons() throws RemoteException {
		if(sons.size() > 0){
			for(SiteItf s : sons ){
				s.receive(this.msg);
			}	
		}

		return true;
	}

}
