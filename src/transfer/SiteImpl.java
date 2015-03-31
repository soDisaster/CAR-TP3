package transfer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SiteImpl extends UnicastRemoteObject implements SiteItf {

	private String nom;
	private float solde;
	
	public SiteImpl() throws RemoteException {
		super();
		this.nom = nom;
	}
	
	public SiteImpl(String s) throws RemoteException {
		super();
		this.nom = s;
	}
	
	public String getTitulaire()  throws RemoteException {
		return nom;
	}

	@Override
	public void deposer(int i)  throws RemoteException{
		System.out.println("Dépôt");
	}

	@Override
	public char[] solde()  throws RemoteException{
		char [] tmp =  {'z','t','g'};
		return tmp; 
	}

	@Override
	public int add(int i, int j)  throws RemoteException{
		
		return i+j;
	}


}
