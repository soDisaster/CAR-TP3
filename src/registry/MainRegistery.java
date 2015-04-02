package registry;

import java.rmi.registry.LocateRegistry;


/**
 * Main_Registery 
 * @author Anne-Sophie Saint-Omer & Thibault Rosa
 */

public class MainRegistery {

	public static void main(String[] args) {
		
		try {
			
			// Register port 1099
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
