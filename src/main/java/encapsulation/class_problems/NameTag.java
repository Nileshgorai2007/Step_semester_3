package encapsulation.class_problems;

public class NameTag {
    private final String nickname;

    public NameTag(String fullName) {
        String[] parts = fullName.trim().split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Full name must contain exactly first and last name");
        }
        this.nickname = parts[0] + " " + parts[1].charAt(0) + ".";
    }

    public String getNickname() {
        return nickname;
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname()); // Maria G.
    }
}
