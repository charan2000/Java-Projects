import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;


public class UDPServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        byte[] bytesRecevied1 = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(bytesRecevied1,bytesRecevied1.length);

        datagramSocket.receive(datagramPacket1);

        String str = new String(datagramPacket1.getData());
        int number = Integer.parseInt(str.trim());
        int result = number*number;

        byte[] bytesRecevied2 = String.valueOf(result).getBytes();
        InetAddress inetAddress = InetAddress.getLocalHost();
        DatagramPacket datagramPacket2 = new DatagramPacket(bytesRecevied2, bytesRecevied2.length,inetAddress,datagramPacket1.getPort());
        datagramSocket.send(datagramPacket2);

    }

}
