import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        DatagramSocket datagramSocket = new DatagramSocket();
        System.out.println("Enter the Number");
        int number = sc.nextInt();

        byte[] bytes1 = String.valueOf(number).getBytes();
        InetAddress inetAddress = InetAddress.getLocalHost();

        DatagramPacket datagramPacket1 = new DatagramPacket(bytes1,bytes1.length,inetAddress,9999);
        datagramSocket.send(datagramPacket1);

        byte[] bytes2 = new byte[1024];
        DatagramPacket datagramPacket2 = new DatagramPacket(bytes2,bytes2.length);
        datagramSocket.receive(datagramPacket2);

        String dataFromServer = new String(datagramPacket2.getData());
        System.out.println("Received from server: " + dataFromServer);

    }

}
