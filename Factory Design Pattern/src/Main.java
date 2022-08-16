import com.mobile.os.*;

public class Main {

    public static void main(String[] args) {

        OSFactoryClass osfc = new OSFactoryClass();

        OS obj = osfc.getOperatingSystem("Secure OS");

        obj.getSpecs();

    }

}