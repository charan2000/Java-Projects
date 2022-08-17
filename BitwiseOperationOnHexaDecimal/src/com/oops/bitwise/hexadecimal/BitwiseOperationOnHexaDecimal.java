package com.oops.bitwise.hexadecimal;//package com.oops.bitwise.hexadecimal;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitwiseOperationOnHexaDecimal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HexValuesImplementation hexImp = new HexValuesImplementation();                 // Object creation for Class that extends abstract class
        PriorityQueue<Integer> hv = new PriorityQueue<>(hexImp.getHexValues(input));    // Creating new Priority queue

        int result = hv.peek();
        int count=0;
        for (int elem: hv) {
            if (count==0) {
                count++;
                continue;
            }
            int b = elem;
            result = result | b;                                    //Bitwise OR (|) with the previous value
            count++;
        }
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

    }

}
