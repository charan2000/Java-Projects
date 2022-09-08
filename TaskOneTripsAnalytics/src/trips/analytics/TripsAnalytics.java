package trips.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TripsAnalytics {

//    Paths for file Input & Output
    private static final String path = "src/trips_view.csv";
    private static final String testPath = "src/TaskOneTripJumps.csv";
    private static String line = "";

    // Method That gets the end Lat & Lon Values and the consecutive Start Lat & Lon values
    private static List<Double> getValuesOfLatLon(int num, String pos) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        int count = 0;
        List<Double> corrArr = new ArrayList<>();
        if (pos.equalsIgnoreCase("start")) {
            while ((line = br.readLine()) != null) {
                if (count == (num)) {
                    String[] arr = line.split(",");
                    corrArr.add(Double.parseDouble(arr[3]));
                    corrArr.add(Double.parseDouble(arr[4]));
                }
                count++;
            }
        } else if (pos.equalsIgnoreCase("end")) {
            while ((line = br.readLine()) != null) {
                if (count == (num)) {
                    String[] arr = line.split(",");
                    corrArr.add(Double.parseDouble(arr[5]));
                    corrArr.add(Double.parseDouble(arr[6]));
                }
                count++;
            }
        }
        return corrArr;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter(testPath));

        String newColumn = "";
        List<Double> startValues;
        List<Double> endValues;
        int distance;
        int count = 0;

        while ((line = br.readLine()) != null) {
            String existingLine = line;
            if(count==0) {
            System.out.println(existingLine);
                bw.write(existingLine+","+"jumpedDistance"+System.getProperty("line.separator"));
            }

            if (count > 1) {
                startValues = getValuesOfLatLon(count, "start");
                endValues = getValuesOfLatLon(count - 1, "end");
                distance = (ConvertionLatLonToKM.latLonToKM(endValues.get(0),endValues.get(1),startValues.get(0),startValues.get(1)));

                // IF statement to get only distance > 5KM
                if (distance > 5) {
                    newColumn = existingLine + ","+distance+System.getProperty("line.separator");
                    System.out.println(newColumn);
                    try{
                        bw.write(newColumn);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                count++;
            }
                br.close();
                bw.close();
            }
        }