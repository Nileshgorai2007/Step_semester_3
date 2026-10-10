package abstraction.assignment_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;
    
    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    
    public abstract LocalDate getRenewalDate();
    public String getName() { return name; }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        SubscriptionPlan[] plans = {
            new BasicPlan("Asha", LocalDate.parse("2024-01-15", fmt)),
            new StandardPlan("Ravi", LocalDate.parse("2024-02-01", fmt)),
            new PremiumPlan("Neha", LocalDate.parse("2024-03-10", fmt)),
            new BasicPlan("Kiran", LocalDate.parse("2024-12-20", fmt))
        };
        
        for (SubscriptionPlan plan : plans) {
            System.out.println(plan.getName() + ": " + plan.getRenewalDate().format(fmt));
        }
    }
}
