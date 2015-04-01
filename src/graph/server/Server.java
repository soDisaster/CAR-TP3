package graph.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import tree.transfer.SiteImpl;
import tree.transfer.SiteItf;

public class Server {

	public static void main(String[] args) throws Exception {

		if(args.length >= 1){
			try {
				LocateRegistry.getRegistry(1099);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			SiteItf RMIObject = new SiteImpl();
			Naming.bind(args[0], RMIObject);

			System.out.println("Node "+args[0]+"Write a message : \n");
			Scanner sc  = new Scanner (System.in);
			String msg ="";
			while(!msg.equals("quit")){
				msg = sc.nextLine();
				RMIObject.receive(msg);
			}
		}
		else {
			System.out.println("Argument missing...");
		}
	} 
}
