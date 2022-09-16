import redis.clients.jedis.Jedis;

public class ClientThree {

    String name = "ClientThree";

    public static void main(String[] args) {

        ClientThree clientThree = new ClientThree();

        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        System.out.println("Connected to Client: 3");

        jedis.rpush(clientThree.name, "8");
        jedis.rpush(clientThree.name, "2");
        jedis.rpush(clientThree.name, "4");
        jedis.rpush(clientThree.name, "1");

    }

}
