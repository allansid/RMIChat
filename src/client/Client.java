package client;

import server.IService;

import java.util.Scanner;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main( String args[] ) {
		try {
			Registry rigistry = LocateRegistry.getRegistry("localhost", 8002);
			final IService chat = (IService) rigistry.lookup( "rmi://localhost:8002/" );

			String user;
			String msg = "";
			
			Scanner in = new Scanner(System.in);
			System.out.println("Digite seu usuario: ");

			user = in.nextLine();

			Thread thread = new Thread(new Runnable() {
				int cont = chat.read().size();
				@Override
				public void run() {
					try {
						while(true){
							if (chat.read().size() > cont){
								System.out.println(chat.read().get(chat.read().size()-1));
								cont++;
							}
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			});
			
			thread.start();

			while(msg != "exit"){
				msg = in.nextLine();
				chat.send(user + ": " + msg);
				// System.out.println(chat.read().get(cont));
			}
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}
}