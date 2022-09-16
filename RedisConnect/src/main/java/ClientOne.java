import redis.clients.jedis.Jedis;

public class ClientOne {

//    private String getName() {
//        return
//    }
String name = "ClientOne";


    public static void main(String[] args) {
        ClientOne clientOne = new ClientOne();
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        System.out.println("Connected to Client: 1");

        jedis.rpush(clientOne.name, "1");
        jedis.rpush(clientOne.name, "2");
        jedis.rpush(clientOne.name, "3");
        jedis.rpush(clientOne.name, "4");
        jedis.rpush(clientOne.name, "3");

    }
}
