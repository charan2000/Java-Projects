package example.car;


public class Person {

    public static void main(String[] args) {

        BasicCar basicCar = new BasicCar();
        Car passengerCar = new PassengerCar(basicCar);
        System.out.println("----- Basic -----\n");
        basicCar.design();

        System.out.println("----- Basic + Passenger-----\n");
        passengerCar.design();

        System.out.println("----- Basic + Passenger + Luxury -----\n");
        Car luxuryPassengerCar = new LuxaryCar(passengerCar);
        luxuryPassengerCar.design();

    }

}
