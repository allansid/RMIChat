package server;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Service extends java.rmi.server.UnicastRemoteObject implements IService {
	
	ArrayList<String> msg;	//buffer

	public Service() throws RemoteException {
		super();
		this.msg = new ArrayList<String>();
	}

	public void send(String msg) throws RemoteException {
		this.msg.add(msg);
	}

	public ArrayList<String> read() throws RemoteException {
		return this.msg;
	}
	
}