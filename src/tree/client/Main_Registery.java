package tree.client;

import java.rmi.registry.LocateRegistry;

public class Main_Registery {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);

		} catch (Exception e) {
			System.err.println("Erreur of registry :"+e);
		}
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
