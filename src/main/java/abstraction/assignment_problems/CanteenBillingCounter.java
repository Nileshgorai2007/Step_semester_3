package abstraction.assignment_problems;

public class CanteenBillingCounter {
    private static final double STUDENT_DISCOUNT = 0.10; // 10% off
    private static final double STAFF_DISCOUNT = 0.05;   // 5% off
    // Guests pay full amount

    private static double finalAmount(String type, double amount) {
        switch (type.toUpperCase()) {
            case "STUDENT": return amount * (1 - STUDENT_DISCOUNT);
            case "STAFF":   return amount * (1 - STAFF_DISCOUNT);
            case "GUEST":   return amount;
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        // Demo data: three bills
        String[] types = {"STUDENT", "STAFF", "GUEST"};
        double[] amounts = {500.0, 750.0, 1200.0};
        double total = 0;
        for (int i = 0; i < types.length; i++) {
            double finalAmt = finalAmount(types[i], amounts[i]);
            System.out.println(types[i] + ": " + String.format("%.2f", finalAmt));
            total += finalAmt;
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}
