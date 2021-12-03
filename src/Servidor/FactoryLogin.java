package Servidor;

import ParteLogin.EnumTipoUser;
import ParteLogin.LoginService;
import ParteLogin.Usuario;
import Servidor.LoginGateway;

public class FactoryLogin {

	public static LoginGateway createGatewayLogin(EnumTipoUser tipoUser) {
		switch (tipoUser) {
		case GOOGLE:
			return new LoginGateway();
//		case FACEBOOK:
//			return new LoginGatewayFacebook();
//		case LOCAL:
//			return new Login();
		}
		return null;
	}
	
}
