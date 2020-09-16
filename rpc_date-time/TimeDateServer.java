// Created for VESIT
// Date 10/09/2020

import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;
import java.util.Date;

class TimeDateServer {
	public static void main(String[] args) {
		System.out.println("Date-Time Server started...");
		try {
			// start server for accepting connections
			ServerSocket serversocket = new ServerSocket(4000);
			Socket socket = serversocket.accept();

			// generate current date and time
			Date date = new Date();
			System.out.println("Current date-time: " + date.toString());

			// send current date and time
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(date.toString());

			// close connection
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
