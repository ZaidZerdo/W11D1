package app3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RingSender {

	public static void main(String[] args) {
		try {
			// Posalji poruku Beciru
			Socket socket = new Socket("10.0.82.37", 6699);
			
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			writer.write("\"Neko ce je promijeniti. :(\" - Zaid");
			writer.newLine();
			writer.close();
			System.out.println("Poslao sam poruku Kristini!");
			
			// Primi poruku od Kristine
			ServerSocket server = new ServerSocket(7777);
			Socket fromBecir = server.accept();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(fromBecir.getInputStream()));
			
			System.out.println("Od Becira: " + reader.readLine());
			
			socket.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
