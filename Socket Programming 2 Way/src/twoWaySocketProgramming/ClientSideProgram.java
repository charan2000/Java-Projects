package twoWaySocketProgramming;

import java.io.*;
import java.net.Socket;

//import static java.lang.System.out;

public class ClientSideProgram {

    public static void main(String[] args) throws IOException {

        int port = 9999;
        String ip = "localhost";

        Socket cs = new Socket(ip,port);
        String name = "Charan";

//        OutputStreamWriter osr = new OutputStreamWriter();
        PrintWriter pw = new PrintWriter(cs.getOutputStream());
        pw.println(name);
        pw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        String serverName = br.readLine();

        System.out.println("C: " + serverName);

    }

}
