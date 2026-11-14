public class TrafficLight {
    private final String id;
    private String currentColor;

    public TrafficLight(String id) {
        this.id = id;
        this.currentColor = "RED";
    }

    public void next() {
        switch (currentColor) {
            case "RED":
                currentColor = "GREEN";
                break;
            case "GREEN":
                currentColor = "YELLOW";
                break;
            case "YELLOW":
            default:
                currentColor = "RED";
                break;
        }
    }

    public String getColor() {
        return currentColor;
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 4: The Traffic Light ===");
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Initial: " + t.getColor());
        t.next();
        System.out.println("Next: " + t.getColor());
        t.next();
        System.out.println("Next: " + t.getColor());
        t.next();
        System.out.println("Next: " + t.getColor());
    }
}
