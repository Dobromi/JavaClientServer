package Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class ClientClass implements ClientInterface{

	private Socket socket;
	private DataOutputStream outToServer;
	
	public ClientClass() throws UnknownHostException, IOException{
		socket=new Socket("localhost",1257);
		outToServer=new DataOutputStream(socket.getOutputStream());
	}
	
	public void sendDataToServer(String input) throws IOException {
		outToServer.writeUTF(input);
		outToServer.flush();
		socket.close();
	}
}