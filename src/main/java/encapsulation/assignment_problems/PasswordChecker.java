package encapsulation.assignment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        if (password == null) throw new IllegalArgumentException("Password cannot be null");
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();
        if (len < 6) return "Weak";
        if (len <= 9) return "Medium";
        return "Strong";
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Strength: " + pc1.getStrength()); // Weak
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("Strength: " + pc2.getStrength()); // Strong
    }
}
