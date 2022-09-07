package trips.anapytics;

class ConvertionLatLonToKM {
    protected static double latLonToKM(double eLat,double eLon, double sLat, double sLon) {
        int radius = 6371;
        double dLat = (eLat-sLat) * (Math.PI/180);  // deg2rad below
        double dLon = (eLon-sLon) * (Math.PI/180);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos((sLat) * (Math.PI/180)) * Math.cos((eLat)*(Math.PI/180)) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = (radius * c);
//        System.out.println(distance);
        return distance;
    }
}