import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;

public class RedisConnection {

    public static int getUniqueValue (List<String> list) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String val : list) {
            Integer count = hashMap.get(val);
            if (hashMap.containsKey(val)) {
                hashMap.put(val, count + 1);
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

        List<String> list1,list2,list3;
        list1 = jds.lrange("ClientOne",0,10);
        list2 = jds.lrange("ClientTwo",0,10);
        list3 = jds.lrange("ClientThree",0,10);

//        System.out.println("Unique Values from ClientOne are: " + getUniqueValue(list1));


    }

}
