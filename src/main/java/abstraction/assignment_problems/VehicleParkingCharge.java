package abstraction.assignment_problems;

public class VehicleParkingCharge {
    private static double chargeForBike(int hours) {
        return 10.0 * hours;
    }
    private static double chargeForCar(int hours) {
        if (hours <= 0) return 0;
        if (hours == 1) return 30.0;
        return 30.0 + 20.0 * (hours - 1);
    }
    private static double chargeForTruck(int hours) {
        double charge = 50.0 * hours;
        return Math.max(charge, 100.0);
    }

    private static double charge(String type, int hours) {
        switch (type.toUpperCase()) {
            case "BIKE": return chargeForBike(hours);
            case "CAR": return chargeForCar(hours);
            case "TRUCK": return chargeForTruck(hours);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        // Demo data
        String[] types = {"BIKE", "CAR", "TRUCK", "CAR"};
        int[] hrs = {3, 4, 1, 1};
        double total = 0;
        for (int i = 0; i < types.length; i++) {
            double c = charge(types[i], hrs[i]);
            System.out.println(types[i] + ": " + String.format("%.2f", c));
            total += c;
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}
