public class BusRouteStopsLinkedList {

    public static class Node {
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node build(String[] stops) {
        if (stops == null || stops.length == 0) return null;
        Node head = new Node(stops[0]);
        Node current = head;
        for (int i = 1; i < stops.length; i++) {
            current.next = new Node(stops[i]);
            current = current.next;
        }
        return head;
    }

    public static void printRoute(Node head) {
        if (head == null) {
            System.out.println("Empty route");
            return;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        String first = head.data;
        String last = head.data;

        Node curr = head;
        while (curr != null) {
            sb.append(curr.data).append(" -> ");
            last = curr.data;
            count++;
            curr = curr.next;
        }
        sb.append("null");

        System.out.println(sb.toString());
        System.out.printf("Stops: %d, First: %s, Last: %s%n", count, first, last);
    }

    public static void main(String[] args) {
        System.out.println("=== Question 1: Bus Route Stops (Linked Chain) ===");
        String[] stops1 = {"Tambaram", "Guindy", "TNagar", "Central"};
        Node route1 = build(stops1);
        printRoute(route1);

        String[] stops2 = {"Potheri"};
        Node route2 = build(stops2);
        printRoute(route2);
    }
}
