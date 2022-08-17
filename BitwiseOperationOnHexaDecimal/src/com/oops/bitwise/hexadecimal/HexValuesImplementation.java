package com.oops.bitwise.hexadecimal;

import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexValuesImplementation extends FilterHexValues {
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
        while (!pq.isEmpty()) {
            Integer i = (int) pq.poll();                                        // Method for printing Priority queue in sorted order
            System.out.println(i);
        }
    }
}
