import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Statement;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("[Server] - " + "Waiting For Client Connection");
        Socket socket = serverSocket.accept();
        System.out.println("[Server] - " + "Client Connected");

        PrintWriter out = new PrintWriter(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String request = br.readLine();
                if (request.contains("name")) {
                    out.print(getRandomName());
                } else {
                    out.print("");
                }
            }
        } finally {
            out.close();
            br.close();
        }

    }

        public static String getRandomName() {

            return null;
        }

}
