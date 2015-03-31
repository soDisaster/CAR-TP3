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
        	// 10000 est le port sur lequel sera publié le service. Nous devons le préciser à la fois sur le registry et à la fois à la création du stub.
            SiteItf skeleton = new SiteImpl("Test"); // Génère un stub vers notre service.
            LocateRegistry.createRegistry(1099);
            Naming.rebind("Site", skeleton); // publie notre instance sous le nom "Add"
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		/*SiteItf compte = new SiteImpl("Bob");
		Naming.bind("Bob", compte);*/
	} 
}
