package Client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;

public class ProxyClientClass implements ClientInterface{

	private ClientClass client;
	
	public ProxyClientClass(){
		client=null;
	}
	
	public void sendDataToServer(String input) throws Exception {
		String [] tokens=input.split("/");
		int year=Integer.parseInt(tokens[0]);int month=Integer.parseInt(tokens[1]);int day=Integer.parseInt(tokens[2]);
		if(year>2014 && year<2020 && month>=0 && month<=11 && day>=0 && day<=31){
			if(client==null){
				client=new ClientClass();
			}
			client.sendDataToServer(input);
		}
		else{
			throw new Exception("Wrong Data provided");
		}
	}

}