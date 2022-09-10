package com.oops.bitwise.hexadecimal;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitwiseOperationOnHexaDecimal {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        HexValuesImplementation hexImp = new HexValuesImplementation();// Object creation for Class that extends abstract class
        PriorityQueue<Integer> hv = new PriorityQueue<>(hexImp.getHexValues(input));    // Creating new Priority queue

        int result = hv.peek();
        int count=0;
        for (int elem: hv) {
            if (count==0) {
//                System.out.println(elem);
                count++;
                continue;
            }
//            System.out.println(elem);
            int b = elem;
            result = result | b;                                    //Bitwise OR (|) with the previous value
            count++;
        }

//      Serialization of PriorityQueue object hv:
        FileOutputStream fos = new FileOutputStream(new File("src/serialization.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(hv);
        fos.close();
        oos.close();

        try{
            if (result < 10 ) {
                throw new Exception();
            }                                                       // Exception if the final result is less than 10 using throw
        }
        catch (Exception e) {
            System.out.println( "Exception: ==> Result is below 10 ");
        }
        System.out.println("Final Result = "+Integer.toHexString(result));  // Printing the final result in hex
        hexImp.getPriorityQueue(hv);
        System.out.println("*** End of Program ***\n");


//      Deserialization of PriorityQueue object hv:
        FileInputStream fis = new FileInputStream(new File("src/serialization.txt"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        PriorityQueue<Integer> newHV = (PriorityQueue<Integer>) ois.readObject();
        System.out.println(newHV);
        fis.close();
        ois.close();

    }

}