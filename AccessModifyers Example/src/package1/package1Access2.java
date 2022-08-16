package package1;

public class package1Access2 {

    public static void main(String[] args) {

        package1Access1 pa1 = new package1Access1();

        System.out.println(pa1.day);        // Accessing default
        System.out.println(pa1.date);

        System.out.println(pa1.Name);       // accessing Public

        System.out.println(pa1.surname);    // Protected

//        System.out.println(pa1.age);        // Private Cant access in another file
//        System.out.println(pa1.salary);



    }

}

