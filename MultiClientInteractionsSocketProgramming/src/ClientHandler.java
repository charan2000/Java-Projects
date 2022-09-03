import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;
    private BufferedReader br;
    private PrintWriter out;


    @Override
    public void run() {

            try {
                while (true) {
                    String request = br.readLine();
                    if(request.contains("name")) {
                        out.println("Type tell me something for random name");
                    }
                }
            }
            catch(IOException e){
                    throw new RuntimeException(e);
                }
            finally {
                out.close();
            }
            }
        }
