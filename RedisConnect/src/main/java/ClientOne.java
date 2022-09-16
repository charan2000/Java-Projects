import redis.clients.jedis.Jedis;

public class ClientOne {

//    private String getName() {
//        return
//    }


    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        System.out.println("Connected to Client: 1");
        String name = "ClientOne";

        jedis.rpush(name, "1");
        jedis.rpush(name, "2");
        jedis.rpush(name, "3");
        jedis.rpush(name, "4");
        jedis.rpush(name, "3");

    }
}
