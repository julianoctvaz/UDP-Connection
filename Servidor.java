import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) throws IOException{
		
		DatagramSocket serverSocket = new DatagramSocket(5000);
		byte[] receberDados = new byte[1024];
		//byte[] enviarDados;
		//InetAddress ipCliente;
		//int porta;
		//Como nao vamos enviar mensagem de volta nao precisamos dessa parte comentada.
		
		while(true) {
			DatagramPacket receberPacote = new DatagramPacket(receberDados, receberDados.length);
			serverSocket.receive(receberPacote);
		//	ipCliente = receberPacote.getAddress();
		//	porta = receberPacote.getPort();
//			enviarDados = ("aqui entra o que, seria a msg kkk tava 2 antes, "
//					+ "acho q ele pega ja da porta 5000 e coloca aqui"
//					+ "segue na linha baixo ele atualizando antes de enviar").getBytes(); 
//			DatagramPacket enviarPacotes = new DatagramPacket(enviarDados, enviarDados.length, ipCliente, porta);
//			serverSocket.send(enviarPacotes);
			
			String msgPraDecodificar  = new String(receberPacote.getData(), "UTF-8");
			System.out.println("Saida no servidor: "+ msgPraDecodificar);
		}
	}

}
