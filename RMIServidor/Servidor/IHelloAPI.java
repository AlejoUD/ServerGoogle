package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHelloAPI extends Remote {
	String sayHello() throws RemoteException;
}