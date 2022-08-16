package package2;

import package1.package1Access1;

public class package2Access2 extends package1Access1 {

    public static void main(String[] args) {

        package2Access2 pa2 = new package2Access2();

        System.out.println(pa2.Name);     //public can be accessed through all the files
                                          // which create its classe's obj

        System.out.println(pa2.surname); //surname is specified using protected which can be accessed
                                         // if we import that class or in the same package

    }

}
