package Login;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILogin extends Remote {
	public String combrobarLogin() throws RemoteException;
	public long loginGoogle(String email, String password) throws RemoteException;
}
