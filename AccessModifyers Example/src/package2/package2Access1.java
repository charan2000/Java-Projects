package package2;

import package1.package1Access1;

public class package2Access1 {

    public static void main(String[] args) {

        package1Access1 pa1 = new package1Access1();

//        System.out.println(pa1.day);        // Accessing default //error because diff package
//        System.out.println(pa1.date);

        System.out.println(pa1.Name);       // accessing Public

//        System.out.println(pa1.surname);     //Protected gives access to evething in the same package unlike public



    }

}
