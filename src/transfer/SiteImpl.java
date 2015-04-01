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
		solde = solde + i;
	}

	@Override
	public void solde() throws RemoteException{
		System.out.println(solde);
	}



}
