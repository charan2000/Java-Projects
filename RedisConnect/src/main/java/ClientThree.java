import redis.clients.jedis.Jedis;

public class ClientThree {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        System.out.println("Connected to Client: 3");
        String name="ClientThree";

        jedis.rpush(name, "8");
        jedis.rpush(name, "2");
        jedis.rpush(name, "4");
        jedis.rpush(name, "1");

    }

}
