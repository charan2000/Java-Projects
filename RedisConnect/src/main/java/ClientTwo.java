import redis.clients.jedis.Jedis;

public class ClientTwo {

    String name = "ClientTwo";

    public static void main(String[] args) {

        ClientTwo clientTwo = new ClientTwo();

        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        System.out.println("Client Connection: 2");
        System.out.println(jedis.ping());

        jedis.rpush(clientTwo.name, "3");
        jedis.rpush(clientTwo.name, "2");
        jedis.rpush(clientTwo.name, "3");
        jedis.rpush(clientTwo.name, "1");

    }
}
