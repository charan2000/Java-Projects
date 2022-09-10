import redis.clients.jedis.Jedis;

import javax.naming.Name;

public class RedisConnection {

    public static void main(String[] args) {

        Jedis jds = new Jedis("localhost");
        String name="Charan";
        jds.set(name, "Python");

//        System.out.println(jds.get(name));
        jds.append(name, " Programming");

        System.out.println("Full Name:" + jds.get(name));
        System.out.println("Sub string : " +jds.getrange(name, 0, 5));

    }

}
