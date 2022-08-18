package twoWaySocketProgramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class ServerSideProgram {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(9999);

        System.out.println("S: Loading for Client-Request");
        Socket soc = ss.accept();

        System.out.println("S: Client Connected");

        BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String name = br.readLine();

        System.out.println("S: " + name + " Connected");

        String serverName = name + "'s Server";

        OutputStreamWriter osw = new OutputStreamWriter(soc.getOutputStream());
        PrintWriter pw = new PrintWriter(osw);
        pw.println(serverName);
        pw.flush();

    }

}
