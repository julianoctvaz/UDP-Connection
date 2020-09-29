import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int porta = 5000;
		String endereco = "localhost";
		
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress ipServidor = InetAddress.getByName(endereco);
		byte[] enviarDados;
		enviarDados = ("1").getBytes();
		DatagramPacket enviarPacote = new DatagramPacket(enviarDados, enviarDados.length, ipServidor, porta);
		
		long tempInicial = System.nanoTime();
		clientSocket.send(enviarPacote);
		byte[] receberDados = new byte[1];
		DatagramPacket receberPacote = new DatagramPacket(receberDados, receberDados.length);
		clientSocket.receive(receberPacote);
		System.out.println("RTT: " + (System.nanoTime() - tempInicial)/1000);
		clientSocket.close();
		
		
	}

}
