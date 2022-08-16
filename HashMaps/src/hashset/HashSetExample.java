package hashset;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<>();
        // Just like a
        hs.add("Charan");
        hs.add("Molly");
        hs.add("Harry");
        hs.add("Albus");
        hs.add("Cedric");

        Iterator<String> iter = hs.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


    }
}
 