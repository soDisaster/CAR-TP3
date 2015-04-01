package graph.client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import graph.transfer.SiteItf;

/**
 * MainClientGraph
 * @author Anne-Sophie Saint-Omer & Thibault Rosa
 */

public class MainClientGraph {
	
	public static void main(String[] args) throws Exception {
		
		try {
            LocateRegistry.getRegistry(1099);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		// RMI Objects 
		SiteItf RMIObj1 = (SiteItf) Naming.lookup("1");
		SiteItf RMIObj2 = (SiteItf) Naming.lookup("2");
		SiteItf RMIObj3 = (SiteItf) Naming.lookup("3");
		SiteItf RMIObj4 = (SiteItf) Naming.lookup("4");
		SiteItf RMIObj5 = (SiteItf) Naming.lookup("5");
		SiteItf RMIObj6 = (SiteItf) Naming.lookup("6");
		
		// Add neighbours
		RMIObj1.addNeighbour(RMIObj2);
		RMIObj1.addNeighbour(RMIObj5);
		RMIObj2.addNeighbour(RMIObj1);
		RMIObj2.addNeighbour(RMIObj3);
		RMIObj2.addNeighbour(RMIObj4);
		RMIObj3.addNeighbour(RMIObj2);
		RMIObj4.addNeighbour(RMIObj2);
		RMIObj4.addNeighbour(RMIObj6);
		RMIObj5.addNeighbour(RMIObj2);
		RMIObj5.addNeighbour(RMIObj6);
		RMIObj6.addNeighbour(RMIObj1);
		RMIObj6.addNeighbour(RMIObj5);
		

	}

}
