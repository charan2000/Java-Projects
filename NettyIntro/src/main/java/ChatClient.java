


public class ChatClient {

    private final String host;
    private final int port;


    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();
    }

}
