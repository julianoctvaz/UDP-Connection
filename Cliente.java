import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException{
		int porta = 5000;
		String endereco = "localhost";
		
		System.out.println("Digite uma mensagem: ");
		Scanner in = new Scanner(System.in);
		String msg = in.nextLine();
  
		
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress ipServidor = InetAddress.getByName(endereco);
		byte[] enviarDados;
		enviarDados = (msg).getBytes();
		DatagramPacket enviarPacote = new DatagramPacket(enviarDados, enviarDados.length, ipServidor, porta);
	
		long tempInicial = System.nanoTime();
		clientSocket.send(enviarPacote);
//		byte[] receberDados = new byte[1024];
//		DatagramPacket receberPacote = new DatagramPacket(receberDados, receberDados.length);
//		clientSocket.receive(receberPacote);
//		System.out.println("RTT: " + (System.nanoTime() - tempInicial)/1000);
		clientSocket.close();
		
		
	}

}
