package trips.anapytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TripsAnalytics {

    private static String path = "/home/charan/oneDeviceTest.csv";
    private static String line="";

    private static List<Double> getValuesOfLatLon(int num, String pos) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        int count=0;
        List<Double> corrArr = new ArrayList<>();
        if(pos.toLowerCase().equals("start")){
            while((line=br.readLine())!=null) {
                if(count == (num)) {
                    String[] arr = line.split(",");
                    corrArr.add(Double.parseDouble(arr[4]));
                    corrArr.add(Double.parseDouble(arr[5]));
                }
                count++;
            }
        }
        else if(pos.toLowerCase().equals("end")) {
            while((line=br.readLine())!=null) {
                if(count == (num)) {
                    String[] arr = line.split(",");
                    corrArr.add(Double.parseDouble(arr[6]));
                    corrArr.add(Double.parseDouble(arr[7]));
                }
                count++;
            }
        }
        return corrArr;
    }

    public static void main(String[] args) throws IOException {

//        String testPath = "/home/charan/testCSV.csv";
        BufferedReader br = new BufferedReader(new FileReader(path));
        int count=0;
        List<Double> startValues=new ArrayList<>();
        List<Double> endValues = new ArrayList<>();
        while((line=br.readLine())!=null) {
            String arr[] = line.split(",");
//            String deviceId = arr[2];

// TODO: 07/09/22 only one particular device/fleet

            if(count>1){

                System.out.println("\nStart Values");
                startValues = getValuesOfLatLon(count,"start");
                System.out.println(startValues);
                System.out.println("End Values");
                endValues=getValuesOfLatLon(count-1,"end");
                System.out.println(endValues);
                double Distance = (ConvertionLatLonToKM.latLonToKM(endValues.get(0),endValues.get(1),startValues.get(0),startValues.get(1)));
                System.out.print("Distance is: ");
                System.out.print(Distance);
//                bw.write((char) Distance);
            }
            count++;
        }
    }
}
