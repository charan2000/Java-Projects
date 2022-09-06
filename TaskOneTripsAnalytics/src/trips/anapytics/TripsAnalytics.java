package trips.anapytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ConvertLatAndLongValuesToKM {
    protected static double latLonToKM(double eLat,double eLon, double sLat, double sLon) {
        int radius = 6371;
        double dLat = (eLat-sLat) * (Math.PI/180);  // deg2rad below
        double dLon = (eLon-sLon) * (Math.PI/180);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos((sLat) * (Math.PI/180)) * Math.cos((eLat)*(Math.PI/180)) *
                   Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = (radius * c);
        System.out.println(distance);
        return distance;
    }
}

public class TripsAnalytics {

    private static String path = "/home/charan/TaskOneTestData.csv";
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

                System.out.println("Start Values");
                startValues = getValuesOfLatLon(count,"start");
//                System.out.println(startValues);
                System.out.println("End Values");
                endValues=getValuesOfLatLon(count-1,"end");
//                System.out.println(endValues);
                double Distance = (ConvertLatAndLongValuesToKM.latLonToKM(endValues.get(0),endValues.get(1),startValues.get(0),startValues.get(1)));

                System.out.println(Distance);
//                bw.write((char) Distance);
            }
            count++;
        }

    }

}
