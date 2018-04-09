package server;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Service extends java.rmi.server.UnicastRemoteObject implements IService {
	
	ArrayList<String> msg; // StringBuffer

	public Service() throws RemoteException {
		super();
		this.msg = new ArrayList<String>();
		//this.msg = new StringBuffer();
	}

	public void send(String msg) throws RemoteException{
		this.msg.add(msg);
		//msg.append(msg + "\n");
	}

	public ArrayList<String> read() throws RemoteException{
		return this.msg;
	}
	
//	public String read2() throws RemoteException{
//	return new String(msg);
//}
	
}