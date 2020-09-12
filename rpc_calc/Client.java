// Created for VESIT
// Date 12/09/2020

import java.net.Socket;
import java.io.*;

class Client {
	public static void main(String[] args) {
		// take input
		int a = Integer.parseInt(args[1]), b = Integer.parseInt(args[2]);
		String calculation = args[0];
		String sendString = calculation + "_" + Integer.toString(a) + "_" + Integer.toString(b);

		// open connection
		try {
			Socket socket = new Socket("localhost", 4000);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(sendString);

			// print result
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = in.readLine();
			System.out.println("Result: " + str);

			// close connection
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}