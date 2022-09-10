package examples;

public class GenericsExamples {

    public static void main(String[] args) {
        Printer<Integer> ip = new Printer<>(97);
        ip.printInput();

        Printer<Double> dp = new Printer<>(99.8);
        dp.printInput();
    }

}
