package Oct10;

class Vehicle {
    protected String color;

    public Vehicle(String color) {
        this.color = color;
        System.out.println("The car is of " + color + " color");
    }

    public void start() {
        System.out.println("The Vehicle has started...");
    }
}

class Car extends Vehicle {
    private int gears;

    public Car(String color, int gears) {
        super(color); // call to base-class constructor
        this.gears = gears;
        System.out.println("The car is running on " + gears);
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car starting with keys and has " + gears + " gears in total");
    }
}

public class InheritanceWays {
    public static void main(String[] args) {
        Car car1 = new Car("Red", 6);
        System.out.println("__________________");
        car1.start();
    }
}
