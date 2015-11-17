package Server;

import java.io.IOException;

public class ServerMain {

	public static void main(String[] args) {
		
		ServerC serv=ServerC.getInstance();
		try {
			serv.ListenForClients();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}