package encapsulation.assignment_problems;

public class HealthBar {
    private final int maxHealth;
    private int health;

    public HealthBar(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount < 0) return;
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        if (amount < 0) return;
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        HealthBar hb = new HealthBar(100);
        hb.takeDamage(30);
        System.out.println(hb.getHealth()); // 70
        hb.heal(50);
        System.out.println(hb.getHealth()); // 100 (capped)
        hb.takeDamage(150);
        System.out.println(hb.getHealth()); // 0 (floored)
    }
}
