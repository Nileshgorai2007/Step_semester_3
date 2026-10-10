package abstraction.assignment_problems;

abstract class Customer {
    protected double billAmount;
    public Customer(double billAmount) {
        this.billAmount = billAmount;
    }
    public abstract double getFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double billAmount) { super(billAmount); }
    @Override public double getFinalAmount() {
        return billAmount * 0.90;
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double billAmount) { super(billAmount); }
    @Override public double getFinalAmount() {
        return billAmount * 0.95;
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double billAmount) { super(billAmount); }
    @Override public double getFinalAmount() {
        return billAmount + 10.0;
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Customer[] customers = {
            new StudentCustomer(200),
            new StaffCustomer(300),
            new GuestCustomer(150)
        };
        
        String[] types = {"STUDENT", "STAFF", "GUEST"};
        double total = 0;
        
        for (int i = 0; i < customers.length; i++) {
            double finalAmount = customers[i].getFinalAmount();
            System.out.println(types[i] + ": " + String.format("%.2f", finalAmount));
            total += finalAmount;
        }
        System.out.println("Total: " + String.format("%.2f", total));
    }
}
