package Socket_Tuan1_Bai1;

import java.io.*;
import java.net.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket socket = new Socket("localhost", 12345);
			
			PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                outToServer.println(inputLine);
                String serverResponse = inFromServer.readLine();
                System.out.println("Server: " + serverResponse);
            }

            socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
