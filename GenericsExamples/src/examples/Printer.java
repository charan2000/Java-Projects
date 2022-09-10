package examples;

public class Printer <T> {

    private final T input;

    public Printer(T input) {
        this.input = input;
    }

    void printInput() {
        System.out.println(input);
    }

}
