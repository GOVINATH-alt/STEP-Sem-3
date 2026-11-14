public class GardenPlotAreaReport {

    public abstract static class GardenPlot {
        String owner;

        public GardenPlot(String owner) {
            this.owner = owner;
        }

        public abstract double getArea();
        public abstract String getShapeName();
    }

    public static class CirclePlot extends GardenPlot {
        double radius;
        public CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }
        @Override public double getArea() { return Math.PI * radius * radius; }
        @Override public String getShapeName() { return "Circular"; }
    }

    public static class RectanglePlot extends GardenPlot {
        double length, width;
        public RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }
        @Override public double getArea() { return length * width; }
        @Override public String getShapeName() { return "Rectangular"; }
    }

    public static class TrianglePlot extends GardenPlot {
        double base, height;
        public TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }
        @Override public double getArea() { return 0.5 * base * height; }
        @Override public String getShapeName() { return "Triangular"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Garden Plot Area Report ===");
        GardenPlot[] plots = {
            new CirclePlot("Alice", 7.0),
            new RectanglePlot("Bob", 10.0, 5.0),
            new TrianglePlot("Charlie", 6.0, 8.0)
        };

        double totalArea = 0;
        for (GardenPlot p : plots) {
            double area = p.getArea();
            totalArea += area;
            System.out.printf("Owner: %-8s | Shape: %-12s | Area: %.2f sq m%n", p.owner, p.getShapeName(), area);
        }
        System.out.printf("Total Area Rented: %.2f sq m%n", totalArea);
    }
}
