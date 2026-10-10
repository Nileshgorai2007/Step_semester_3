package abstraction.class_problems;

abstract class PaymentMethod {
    protected double amount;
    public PaymentMethod(double amount) { this.amount = amount; }
    public abstract double calculateFee();
    public double getAdjustedAmount() { return amount + calculateFee(); }
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) { super(amount); }
    @Override public double calculateFee() { return amount * 0.02; }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) { super(amount); }
    @Override public double calculateFee() { return amount * 0.01; }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) { super(amount); }
    @Override public double calculateFee() { return 0; }
}

public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        String[] types = {"CARD", "WALLET", "BANKTRANSFER"};
        double[] amounts = {1000.0, 500.0, 2000.0};
        double total = 0;
        
        for (int i = 0; i < types.length; i++) {
            PaymentMethod pm;
            if (types[i].equals("CARD")) pm = new CardPayment(amounts[i]);
            else if (types[i].equals("WALLET")) pm = new WalletPayment(amounts[i]);
            else pm = new BankTransferPayment(amounts[i]);
            
            double adjusted = pm.getAdjustedAmount();
            System.out.println(types[i] + ": " + String.format("%.2f", adjusted));
            total += adjusted;
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}
