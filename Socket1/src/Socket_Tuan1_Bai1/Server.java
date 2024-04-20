package Socket_Tuan1_Bai1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			
			System.out.println("Waiting for client to connect...");
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client connected!");
			
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);
			
			BufferedReader serverReader = new BufferedReader(new InputStreamReader(System.in));
			String inputLine;
			while((inputLine = inFromClient.readLine()) != null) {
				System.out.println("Client: " + inputLine);
				System.out.println("server: ");
				String serverInput = serverReader.readLine();
				outToClient.println(serverInput);
			}
			
			serverSocket.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
