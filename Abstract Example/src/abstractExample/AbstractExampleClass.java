package abstractExample;


abstract class Animal {
    void display() {
        System.out.println("Abstract Class Called:");
    }

    abstract void methodAbstract();     // Cannot hava body

}

class Dog extends Animal {
    @Override
    void methodAbstract() {    // Should be implemented here in class which abstract class is inherited
        System.out.println("Implementation in derrived class");
    }
}         // Class inheriting Abstract class

public class AbstractExampleClass {

    public static void main(String[] args) {

        Dog d = new Dog();
        d.display();
        d.methodAbstract();

    }

}