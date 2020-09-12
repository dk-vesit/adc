// Created for VESIT
// Date 12/09/2020

import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

class CalculatorServer {
	public static void main(String[] args) {
		System.out.println("Calculator server started...");
		try {
			// open connection
			ServerSocket serversocket = new ServerSocket(4000);
			Socket socket = serversocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String clientString = in.readLine();

			// format client arguments
			String client_args[] = clientString.split("_");
			int a = Integer.parseInt(client_args[1]);
			int b = Integer.parseInt(client_args[2]);
			int result = 0;
			System.out.println(client_args[0] + "(" + client_args[1] + ", " + client_args[2] + ") called");

			// calculate result
			switch (client_args[0]) {
				case "add":
					result = a + b;
					break;
				case "subtract":
					result = a - b;
					break;
				case "multiply":
					result = a * b;
					break;
				case "divide":
					result = a / b;
					break;
			}

			// send result
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(result);

			// close connection
			socket.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}