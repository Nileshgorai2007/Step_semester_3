package abstraction.assignment_problems;

abstract class Vehicle {
    protected int hours;
    public Vehicle(int hours) {
        this.hours = hours;
    }
    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    @Override public double calculateCharge() {
        return 10.0 * hours;
    }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    @Override public double calculateCharge() {
        if (hours <= 0) return 0;
        return 30.0 + 20.0 * (hours - 1);
    }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    @Override public double calculateCharge() {
        return Math.max(100.0, 50.0 * hours);
    }
}

public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Bike(3),
            new Car(4),
            new Truck(1),
            new Car(1)
        };
        
        String[] types = {"BIKE", "CAR", "TRUCK", "CAR"};
        double total = 0;
        
        for (int i = 0; i < vehicles.length; i++) {
            double charge = vehicles[i].calculateCharge();
            System.out.println(types[i] + ": " + String.format("%.2f", charge));
            total += charge;
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}
