import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;

public class RedisConnection {

    public static int getUniqueValue (List<String> list) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String val : list) {
            Integer count = hashMap.get(val);
            if (hashMap.containsKey(val)) {
                Integer put = hashMap.put(val, count + 1);
            }
            else if (count == null){
                hashMap.put(val, 1);
            }
        }
        int temp=0;
        for (int val: hashMap.values()) {
            if ( val > 1 ){
                continue;
            }
            else{
                temp++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {

        Jedis jds = new Jedis("localhost");

        String client1 = new ClientOne().name;
        String client2 = new ClientTwo().name;
        String client3 = new ClientThree().name;

        List<String> list1,list2,list3;
        list1 = jds.lrange(client1,0,10);
        list2 = jds.lrange(client2,0,10);
        list3 = jds.lrange(client3,0,10);

        System.out.println("Unique Values from " + client1.toString() + " are: " + getUniqueValue(list1));
        System.out.println("Unique Values from " + client2.toString() + " are: " + getUniqueValue(list2));
        System.out.println("Unique Values from " + client3.toString() + " are: " + getUniqueValue(list3));

//        System.out.println(getUniqueValue(list1));


    }

}
