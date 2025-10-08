import java.util.Scanner;

class Vehicle{
    public void engine(){
        System.out.println("Vehicle Engine Started...");
    }
}

class Car extends Vehicle{
    private int gear;
    public Car(int gear){
        this.gear = gear;
    }
    public Car(){
        this.gear = 1; // default gear value
    }

    @Override
    public void engine(){
        System.out.println("Car engine started...");
    }

    public void gearUp(){
        this.gear++;
        System.out.println("GearUp by 1. Current gear: " + this.gear);
    }
    public void gearDown(){
        this.gear--;
        System.out.println("Cannot geardown below 1. Current gear: " + this.gear);
    }

    public void accelerate(){
        System.out.println("Accelerating car...");
    }
}

public class InheritancePractice{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Car car1 = new Car();
        car1.engine();
        car1.gearDown();
        car1.gearUp();
    }
}