package graph.client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import tree.transfer.SiteItf;

public class MainClientGraphe {

public static void main(String[] args) throws Exception {
		
		try {
            LocateRegistry.getRegistry(1099);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		SiteItf RMIObj1 = (SiteItf) Naming.lookup("1");
		SiteItf RMIObj2 = (SiteItf) Naming.lookup("2");
		SiteItf RMIObj3 = (SiteItf) Naming.lookup("3");
		SiteItf RMIObj4 = (SiteItf) Naming.lookup("4");
		SiteItf RMIObj5 = (SiteItf) Naming.lookup("5");
		SiteItf RMIObj6 = (SiteItf) Naming.lookup("6");
		
		
		RMIObj1.addSon(RMIObj2);
		RMIObj1.addSon(RMIObj5);
		RMIObj2.addSon(RMIObj3);
		RMIObj2.addSon(RMIObj4);
		RMIObj5.addSon(RMIObj6);
		
		RMIObj1.setFather(null);
		RMIObj2.setFather(RMIObj1);
		RMIObj5.setFather(RMIObj1);
		RMIObj3.setFather(RMIObj2);
		RMIObj4.setFather(RMIObj2);
		RMIObj6.setFather(RMIObj5);
	}

}
