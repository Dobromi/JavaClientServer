package Client;

import java.util.Date;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(true){
			System.out.println("Type a Date for which you want to see exams in Y/M/D format");
			String input=in.next();
			System.out.println(input);
			ClientInterface clientObj=new ProxyClientClass();
			try {
				clientObj.sendDataToServer(input);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}