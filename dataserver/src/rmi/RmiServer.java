package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer {
	
	private static RmiImplementation rmiImplementation;
	private static Registry r = null;
	
	public static void start() {
		try {
			try {
				rmiImplementation = new RmiImplementation();
				if(r == null) {
					r = LocateRegistry.createRegistry(RmiInterface.RMI_PORT);
				}
				r.rebind(RmiInterface.RMI_NAME, rmiImplementation);
			} catch(ExportException ex) {
				ex.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void stop() {
		try {
			UnicastRemoteObject.unexportObject(r, true);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
