package hashmaps;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        //Inserting data into hm
        hm.put("Charan", 21);
        hm.put("Kiran", 19);
        hm.put("Vishnu", 22);

        // For Accessing this hm we have multiple ways

        //Prints all the keys
        for(String name: hm.keySet()) {
            System.out.println( name);
        }

        // For printing only values of the keys
        for(Integer age: hm.values()) {
            System.out.println(age);
        }

        // For printing both the value and keys using entrySet
        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
