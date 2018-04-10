package client;

import java.util.Scanner;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.IService;

public class Client {

	public static void main( String args[] ) {
		try {

			int port = 8002;
			String user, msg = "";

			Registry rigistry = LocateRegistry.getRegistry("localhost", port);
			IService chat = (IService) rigistry.lookup("rmi://localhost:"+port+"/");
			
			Scanner in = new Scanner(System.in);
			System.out.println("Digite seu usuario: ");
			user = in.nextLine();

			Thread t = new Thread(new Runnable() {
				int cont = chat.read().size();
				@Override
				public void run() {
					try {
						while(true) {
							if (chat.read().size() > cont) {
								System.out.println(chat.read().get(chat.read().size()-1));
								cont++;
							}
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			});
			
			t.start();

			while(msg != "quit") {
				msg = in.nextLine();
				chat.send("["+user+"]" + ": " + msg);
			}
			
			in.close();
		
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}