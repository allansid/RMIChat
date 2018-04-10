package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	public Server() {
		try {
			
			int port = 8002;

			Registry registry = LocateRegistry.createRegistry(port);
			IService service = new Service();
			registry.bind("rmi://localhost:"+port+"/", service);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main (String args[]) {
		new Server();
	}

}