package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public Server(){
		try {
			Registry registry = LocateRegistry.createRegistry(8002);
			IService service = new Service();
			registry.bind("rmi://localhost:8002/", service);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	public static void main (String args[]){
		new Server();
	}

}