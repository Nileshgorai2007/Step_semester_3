package abstraction.assignment_problems;

abstract class Room {
    protected int units;
    public Room(int units) {
        this.units = units;
    }
    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) { super(units); }
    @Override public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;
    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    @Override public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) { super(units); }
    @Override public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Room[] rooms = {
            new SingleRoom(120),
            new SharedRoom(150, 3),
            new ACRoom(100)
        };
        
        String[] types = {"SINGLE", "SHARED", "AC"};
        double total = 0;
        
        for (int i = 0; i < rooms.length; i++) {
            double bill = rooms[i].calculateBill();
            System.out.println(types[i] + ": " + String.format("%.2f", bill));
            total += bill;
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}
