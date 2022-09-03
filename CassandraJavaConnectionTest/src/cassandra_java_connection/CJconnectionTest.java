package cassandra_java_connection;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.ResultSet;


public class CJconnectionTest {

    public static void main(String[] args) {
        System.out.println("*********** Testing Java Connection ***********");

        Cluster cluster;
        Session session;

        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("java_connection");

        

    }

}
