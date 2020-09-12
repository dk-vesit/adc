import java.util.*;
import java.io.*;
import java.net.*;

public class MyClient {
	public static void main(String[] args) {
		try {	
			Socket s=new Socket("localhost",6666);
			/*DataInputStream dis=new DataInputStream(s.getInputStream());


			String	str=(String)dis.readUTF();
			System.out.println("message= "+str);*/
				
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());

			dout.writeUTF("Hi server! How are you?");
			 Thread t=new Thread();
			 t.sleep(5000);
			dout.flush();


			//dout.close();



			DataInputStream dis=new DataInputStream(s.getInputStream());


			String	str=(String)dis.readUTF();
			System.out.println("message= "+str);

			//s.close();
			dout.close();
			s.close();

		} catch(Exception e) {System.out.println(e);}
	}
}