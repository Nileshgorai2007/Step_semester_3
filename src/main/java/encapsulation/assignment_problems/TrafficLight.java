package encapsulation.assignment_problems;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // start at RED
    }

    public void next() {
        switch (color) {
            case "RED":
                color = "GREEN";
                break;
            case "GREEN":
                color = "YELLOW";
                break;
            case "YELLOW":
                color = "RED";
                break;
            default:
                throw new IllegalStateException("Invalid color: " + color);
        }
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight tl = new TrafficLight("TL-9");
        System.out.println(tl.getColor()); // RED
        tl.next();
        System.out.println(tl.getColor()); // GREEN
        tl.next();
        System.out.println(tl.getColor()); // YELLOW
        tl.next();
        System.out.println(tl.getColor()); // RED
    }
}
