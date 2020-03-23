package thies.Prisoners_Dilemma.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main_Client {
	private static Strategy strat;
	
	public static void main(String[] args) throws IOException {
		System.out.println("IP-adress of server:");
		Scanner scanner = new Scanner(System.in);
		String ip = scanner.nextLine();
		scanner.close();
		String currentStrategy = "null";
		
		boolean stratSelected = false;
		while(stratSelected = false) {
			System.out.println("What strategy are you using?");
			System.out.println("0 = tft_Omega");
			System.out.println("1 = Lucifer");
			System.out.println("2 = LucifersMinion");
			scanner = new Scanner(System.in);
			currentStrategy = scanner.nextLine();
			scanner.close();
			switch (currentStrategy) {
			case "0":
				strat = new Strategy_tft_Omega();
				stratSelected = true;
				currentStrategy = "tft_Omega";
				break;
			case "1":
				strat = new Strategy_Lucifer();
				stratSelected = true;
				currentStrategy = "Lucifer";
				break;
			case "2":
				strat = new Strategy_LucifersMinion();
				stratSelected = true;
				currentStrategy = "LucifersMinion";
				break;
			default:
				System.out.println(currentStrategy + " is not a valid option");
				System.out.println("valid options are:");
				System.out.println("0 = tft_Omega");
				System.out.println("1 = Lucifer");
				System.out.println("2 = LucifersMinion");
			}
		}
		
		
		String message;
		int newPort;
		ServerSocket listenOn = new ServerSocket(7654);
		Socket mySocket = new Socket(ip, 7654);
		
		

		
		if(listen(listenOn) == "HELLO?") {
			message = "introducing Thies_" + currentStrategy;
			send(message, mySocket);
		}
		newPort = Integer.parseInt(listen(listenOn));
		startGame(newPort, ip);
		
	}
	
	public static String listen(ServerSocket listenOn) {
		String message = "null";
		try {
			Socket mySocket = listenOn.accept();
			DataInputStream readFromMe = new DataInputStream(mySocket.getInputStream());
			message = readFromMe.readUTF();
			System.out.println(message + " recieved");
			listenOn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return message;
	}
	
	public static void send(String message, Socket mySocket) {
		try {
			DataOutputStream iSay = new DataOutputStream(mySocket.getOutputStream());
			System.out.println("Sending: " + message);
			iSay.writeUTF(message);
			iSay.flush();
			iSay.close();
			mySocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void startGame(int newPort, String ip) {
		try {
			ServerSocket listenOn = new ServerSocket(newPort);
			Socket mySocket = new Socket(ip, newPort);
			if(listen(listenOn) == "JOIN, TEST OR QUIT") {
				boolean selected = false;
				while(selected == false) {
					System.out.println("select gamemode:");
					System.out.println("JOIN");
					System.out.println("TEST");
					System.out.println("QUIT");
					Scanner scanner = new Scanner(System.in);
					String gamemode = scanner.nextLine();
					if(gamemode != "JOIN" && gamemode != "TEST" && gamemode != "QUIT") {
						System.out.println(gamemode + " is not a valid gamemode");
						System.out.println("valid gamemodes are: JOIN, TEST, QUIT");
					} else {
						selected = true;
					}
				}
				if(listen(listenOn) == "BEGIN") {
					play(listenOn, mySocket);
				}
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	
	public static void play(ServerSocket listenOn, Socket mySocket) {
		String myMoveString;
		String otherMoveString;
		char myMove = strat.getMove();
		
	}
}
