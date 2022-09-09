package trips.analytics;

class ConvertionLatLonToKM {

    protected static int latLonToKM(double eLat,double eLon, double sLat, double sLon) {

        int radius = 6371;
        double dLat = (eLat-sLat) * (Math.PI/180);
        double dLon = (eLon-sLon) * (Math.PI/180);

//      Haversine method to Calculate Distance using Latitide and Longitude Values
        double a = Math.sin(dLat/2) * Math.sin(dLat/2)
                + Math.cos((sLat) * (Math.PI/180)) * Math.cos((eLat)*(Math.PI/180))
                * Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return (int) Math.round(radius * c);

    }
}