package abstraction.assignment_problems;

abstract class Employee {
    protected String name;
    protected double monthlySalary;
    
    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }
    
    public abstract double calculateBonus();
    public String getName() { return name; }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    public Intern(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override public double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Employee[] employees = {
            new FullTimeEmployee("Asha", 50000),
            new PartTimeEmployee("Ravi", 30000),
            new Intern("Neha", 15000)
        };
        
        double totalBonus = 0;
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            System.out.println(emp.getName() + ": " + String.format("%.2f", bonus));
            totalBonus += bonus;
        }
        System.out.println("Total Bonus: " + String.format("%.2f", totalBonus));
    }
}
