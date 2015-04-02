package tree.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import tree.transfer.SiteImpl;
import tree.transfer.SiteItf;

/**
 * Server
 * @author Anne-Sophie Saint-Omer & Thibault Rosa
 */

public class Server {

	public static void main(String[] args) throws Exception {

		// If the number of arguments is not equal to 1.
		if(args.length >= 1 ){
			try {
				
				// Register port 1099
				LocateRegistry.getRegistry(1099);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Instanstation of one RMI Object
			
			SiteItf RMIObject = new SiteImpl();
			Naming.bind(args[0], RMIObject);

			System.out.println("Node "+args[0]+"\n Write a message : \n");
			
			// Scanner for the message
			Scanner sc  = new Scanner (System.in);
			String msg ="";
			// If message is different of quit, the programm wait to read a message
			while(!msg.equals("quit")){
				msg = sc.nextLine();
				RMIObject.receive(msg.getBytes());
			}
			sc.close();
		}
		else {
			System.out.println("Argument missing : java -jar NodeTree.jar [numberOfNode]");
		}
	} 
}
