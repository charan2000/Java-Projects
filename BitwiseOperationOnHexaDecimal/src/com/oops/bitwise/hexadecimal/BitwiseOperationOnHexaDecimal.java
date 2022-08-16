package com.oops.bitwise.hexadecimal;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class FilterHexValues {
    abstract PriorityQueue<Integer> getHexValues(String str);                   //Abstract Class with abstract method
}

class HexValuesImplementation extends FilterHexValues {
    @Override
    PriorityQueue<Integer> getHexValues(String str) {                           // Overriding abstract method

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[] inputStr = str.split(" ");

        Pattern p = Pattern.compile("0x{1}[0-9a-fA-F]+");

        for (String s : inputStr) {
            Matcher m = p.matcher(s);
            if (m.matches()) {
                pq.add(Integer.parseInt(s.substring(2, s.length()), 16));  // Method Chaining // And taking only hex value
                                                                                // after 0x using substring method
            }
        }
        return pq;
    }

    void getPriorityQueue(PriorityQueue pq) {
        System.out.println("Sorted Priority queue is: ");
        while(!pq.isEmpty()) {
            Integer i = (int) pq.poll();                                        // Method for printing Priority queue in sorted order
            System.out.println(i);
        }
    }
}

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
//                System.out.println(elem);
                count++;
                continue;
            }
//            System.out.println(elem);
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
