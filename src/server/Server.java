package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import transfer.SiteImpl;
import transfer.SiteItf;

public class Server {

	public static void main(String[] args) throws Exception {
		
		try {
        	LocateRegistry.createRegistry(1099);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		SiteItf compte = new SiteImpl("Bob");
		Naming.bind("Bob", compte);
	} 
}
