package abstraction.class_problems;

abstract class Plot {
    protected String owner;
    public Plot(String owner) { this.owner = owner; }
    public abstract double area();
    public String report() {
        return owner + " (" + this.getClass().getSimpleName().toUpperCase() + "): " + String.format("%.2f", area());
    }
}

class CirclePlot extends Plot {
    private double radius;
    public CirclePlot(String owner, double radius) { super(owner); this.radius = radius; }
    @Override public double area() { return Math.PI * radius * radius; }
}

class RectanglePlot extends Plot {
    private double length, width;
    public RectanglePlot(String owner, double length, double width) { super(owner); this.length = length; this.width = width; }
    @Override public double area() { return length * width; }
}

class TrianglePlot extends Plot {
    private double base, height;
    public TrianglePlot(String owner, double base, double height) { super(owner); this.base = base; this.height = height; }
    @Override public double area() { return 0.5 * base * height; }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        // Example input parsing omitted; demo with hard‑coded data
        Plot[] plots = new Plot[] {
            new CirclePlot("Alice", 3.0),
            new RectanglePlot("Bob", 4.0, 5.0),
            new TrianglePlot("Cara", 6.0, 2.0)
        };
        double total = 0;
        for (Plot p : plots) {
            System.out.println(p.report());
            total += p.area();
        }
        System.out.println("Total Area: " + String.format("%.2f", total));
    }
}
