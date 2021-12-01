package ParteLogin;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILogin extends Remote {
	public String combrobarLogin() throws RemoteException;
}
