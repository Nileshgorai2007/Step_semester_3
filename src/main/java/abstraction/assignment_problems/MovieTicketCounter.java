package abstraction.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class MovieTicketCounter {
    private static final double REGULAR_PRICE = 150.0;
    private static final double PREMIUM_PRICE = 250.0;
    private static final double RECLINER_PRICE = 350.0;
    private static final double CONVENIENCE_FEE = 20.0;

    public static double priceForSeat(String seat) {
        switch (seat.toUpperCase()) {
            case "REGULAR": return REGULAR_PRICE;
            case "PREMIUM": return PREMIUM_PRICE;
            case "RECLINER": return RECLINER_PRICE;
            default: throw new IllegalArgumentException("Unknown seat type: " + seat);
        }
    }

    public static void main(String[] args) {
        // Demo data: 3 bookings
        String[] seats = {"REGULAR", "PREMIUM", "RECLINER"};
        int[] counts = {2, 1, 3};
        double total = 0;
        for (int i = 0; i < seats.length; i++) {
            double subtotal = (priceForSeat(seats[i]) + CONVENIENCE_FEE) * counts[i];
            System.out.println(seats[i] + " x" + counts[i] + " => " + String.format("%.2f", subtotal));
            total += subtotal;
        }
        System.out.println("Total Collected: " + String.format("%.2f", total));
    }
}
