package example.car;

class Decorator implements Car{

    private final Car car;

    public Decorator(Car car) {
        this.car = car;
    }

    @Override
    public void design() {
        this.car.design();
    }

}
