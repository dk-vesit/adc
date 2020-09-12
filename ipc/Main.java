import java.io.*;
import java.util.*;
import java.net.*;

public class Main {
	public static void main(String[] args){
		try {
			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();//establishes connection 

			DataInputStream dis=new DataInputStream(s.getInputStream());


			String	str=(String)dis.readUTF();
			System.out.println("message= "+str);


			//TimerTask tasknew = new TimerTask();
			   Thread t=new Thread();
			      
			   // scheduling the task at interval
			   t.sleep(4000);  

			DataOutputStream dout=new DataOutputStream(s.getOutputStream());

			dout.writeUTF("Hi client! I am fine.");
			dout.flush();

			dout.close();

			ss.close();

		} catch(Exception e) {System.out.println(e);}
	}
}
