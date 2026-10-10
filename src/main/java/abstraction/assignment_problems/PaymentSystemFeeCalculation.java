package abstraction.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class PaymentSystemFeeCalculation {
    private enum PaymentType {
        CARD(0.02),
        WALLET(0.015),
        BANKTRANSFER(0.005);
        private final double feeRate;
        PaymentType(double feeRate) { this.feeRate = feeRate; }
        public double feeRate() { return feeRate; }
    }

    private static double finalAmount(PaymentType type, double amount) {
        return amount + (amount * type.feeRate());
    }

    public static void main(String[] args) {
        // Demo data
        String[] types = {"CARD", "WALLET", "BANKTRANSFER"};
        double[] amounts = {1000.0, 500.0, 2500.0};
        double total = 0;
        for (int i = 0; i < types.length; i++) {
            PaymentType pt = PaymentType.valueOf(types[i]);
            double finalAmt = finalAmount(pt, amounts[i]);
            System.out.println(types[i] + ": " + String.format("%.2f", finalAmt));
            total += finalAmt;
        }
        System.out.println("Total Processed: " + String.format("%.2f", total));
    }
}
