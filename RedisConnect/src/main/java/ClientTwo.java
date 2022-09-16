import redis.clients.jedis.Jedis;

public class ClientTwo {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        System.out.println("Client Connection: 2");
        System.out.println(jedis.ping());
        String name="ClientTwo";

        jedis.rpush(name, "3");
        jedis.rpush(name, "2");
        jedis.rpush(name, "3");
        jedis.rpush(name, "1");

    }
}
