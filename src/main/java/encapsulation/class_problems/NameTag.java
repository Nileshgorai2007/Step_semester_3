package encapsulation.class_problems;

public class NameTag {
    private final String firstName;
    private final String lastInitial;

    public NameTag(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty");
        }
        String[] parts = fullName.split(" ");
        if (parts.length >= 2) {
            this.firstName = parts[0];
            this.lastInitial = parts[1].substring(0, 1) + ".";
        } else {
            this.firstName = parts[0];
            this.lastInitial = "";
        }
    }

    public String getNickname() {
        if (lastInitial.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastInitial;
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname()); // Maria G.
    }
}
