package Servidor;

import Gateway.LoginGateway;
import Login.EnumTipoUser;
import Login.LoginService;
import Login.Usuario;

public class FactoryLogin {
	LoginGateway login;
	public static LoginGateway createGatewayLogin(EnumTipoUser tipoUser) {
		switch (tipoUser) {
		case GOOGLE:
			return null;
//		case FACEBOOK:
//			return new LoginGatewayFacebook();
//		case LOCAL:
//			return new Login();
		}
		return null;
	}
	
}
