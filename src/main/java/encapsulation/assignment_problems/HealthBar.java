package encapsulation.assignment_problems;

public class HealthBar {
    private final int maxHealth;
    private int health;

    public HealthBar(int maxHealth) {
        if (maxHealth <= 0) throw new IllegalArgumentException("maxHealth must be positive");
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount < 0) throw new IllegalArgumentException("damage cannot be negative");
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        if (amount < 0) throw new IllegalArgumentException("heal amount cannot be negative");
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        HealthBar hb = new HealthBar(100);
        hb.takeDamage(30);
        System.out.println("Health after 30 dmg: " + hb.getHealth()); // 70
        hb.heal(50);
        System.out.println("Health after heal 50: " + hb.getHealth()); // 100
        hb.takeDamage(150);
        System.out.println("Health after 150 dmg: " + hb.getHealth()); // 0
    }
}
