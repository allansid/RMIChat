package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IService extends Remote {
	
	public void send(String msg) throws RemoteException;
	
	public ArrayList<String> read() throws RemoteException;

}