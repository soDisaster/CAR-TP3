package client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import transfer.SiteItf;

public class Client {

	public static void main(String[] args) throws Exception {
		try {
            LocateRegistry.getRegistry(1099);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		SiteItf compte = (SiteItf) Naming.lookup("Bob");
		compte.deposer(10);
		compte.deposer(40);
		compte.solde();
	} 
}
