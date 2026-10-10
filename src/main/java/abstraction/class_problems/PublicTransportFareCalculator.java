package abstraction.class_problems;

abstract class Transport {
    protected double distance;
    public Transport(double distance) {
        this.distance = distance;
    }
    public abstract double calculateFare();
}

class BusTransport extends Transport {
    public BusTransport(double distance) { super(distance); }
    @Override public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
}

class TrainTransport extends Transport {
    public TrainTransport(double distance) { super(distance); }
    @Override public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroTransport extends Transport {
    private double peakHourFactor;
    public MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    @Override public double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Transport[] journeys = {
            new BusTransport(15),
            new TrainTransport(50),
            new MetroTransport(10, 1.5)
        };
        
        String[] types = {"BUS", "TRAIN", "METRO"};
        double total = 0;
        
        for (int i = 0; i < journeys.length; i++) {
            double fare = journeys[i].calculateFare();
            System.out.println(types[i] + ": " + String.format("%.2f", fare));
            total += fare;
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}
