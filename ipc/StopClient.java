import java.util.*;
import java.io.*;
import java.net.*;

public class StopClient {
public static void main(String[] args) {
try{	
Socket s=new Socket("localhost",8888);

DataOutputStream dout=new DataOutputStream(s.getOutputStream());
System.out.println("Window Size is 1\n");
dout.writeUTF("Frame 0");
System.out.println("Timer 0 started");
System.out.println("Frame 0 sent");
 Thread t=new Thread();
 t.sleep(5000);
dout.flush();

DataInputStream dis=new DataInputStream(s.getInputStream());


String	str=(String)dis.readUTF();
System.out.println("message= "+str+" recived");
System.out.println("Timer 0 stopped\n");

System.out.println("Timer 1 started");
t.sleep(2000);
System.out.println("Frame 1 sent");


t.sleep(6000);
System.out.println("Time out for timer 1, frame 1 might be lost\n");
System.out.println("Timer 1 started again");
System.out.println("Resending Frame 1");
dout.writeUTF("Frame 1");
dout.flush();
t.sleep(9000);
System.out.println("Time-out for timer 1\n");
//System.out.println("ACK 0 lost");
System.out.println("Timer 1 started again");
System.out.println("Resending Frame 1");

//s.close();
dout.close();
s.close();
t.sleep(6000);
System.out.println("ACK 0 received");
}catch(Exception e){System.out.println(e);}
}
}