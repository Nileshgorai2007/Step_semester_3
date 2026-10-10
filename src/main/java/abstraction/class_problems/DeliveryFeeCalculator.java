package abstraction.class_problems;

abstract class Delivery {
    protected double weight;
    protected double distance;
    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }
    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) { super(weight, distance); }
    @Override public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) { super(weight, distance); }
    @Override public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;
    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }
    @Override public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Delivery[] deliveries = {
            new StandardDelivery(10, 50),
            new ExpressDelivery(5, 20),
            new InternationalDelivery(20, 100, 30)
        };
        
        String[] types = {"STANDARD", "EXPRESS", "INTERNATIONAL"};
        double total = 0;
        
        for (int i = 0; i < deliveries.length; i++) {
            double fee = deliveries[i].calculateFee();
            System.out.println(types[i] + ": " + String.format("%.2f", fee));
            total += fee;
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}
