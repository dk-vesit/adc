// Created for VESIT
// Date 16/09/2020

import java.net.Socket;
import java.io.*;

class Client {
	public static void main(String[] args) {
		try {
			// connect to server
			Socket socket = new Socket("localhost", 4000);

			// print result
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String s = in.readLine();
			System.out.println("Time and date from server: " + s);

			// close connection
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}