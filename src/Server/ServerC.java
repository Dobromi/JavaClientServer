package Server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Iterator;
import Data.ExamDateClass;
import Data.ExamDateClassContainer;
import Data.StaticData;

public class ServerC {

	private static ServerC instance=null;
	private ServerC(){}
	
	public static ServerC getInstance(){
		if(instance==null){
			instance=new ServerC();
		}
		return instance;
	}
	
	public void ListenForClients() throws IOException{
		ServerSocket serv=new ServerSocket(1257);
		DataInputStream fromClient=null;
		StaticData data=new StaticData();
		data.LoadData();
		ExamDateClassContainer cont=data.getCont();
		while(true){
			System.out.println("Server Listening...");
			Socket s=serv.accept();
			fromClient=new DataInputStream(s.getInputStream());
			String inputFromClient=fromClient.readUTF();
			String [] tokens=inputFromClient.split("/");
			int year=Integer.parseInt(tokens[0]);int month=Integer.parseInt(tokens[1]);int day=Integer.parseInt(tokens[2]);
			
			Date dateObj=new Date(year,month,day);
			
			//Check for exam on this date now
			Iterator it=cont.iterator();
			while(it.hasNext()){
				ExamDateClass examObj=(ExamDateClass) it.next();
				if(examObj.getDate().getYear()==dateObj.getYear() && 
						examObj.getDate().getMonth()==dateObj.getMonth() &&
						examObj.getDate().getDate()==dateObj.getDate()){
					System.out.println(examObj.toString());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
		
	}
	
}