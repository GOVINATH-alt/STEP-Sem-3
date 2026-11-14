public class CancelBookingLinkedList {

    public static class Node {
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node prev = head;
        Node curr = head.next;
        boolean found = false;

        while (curr != null) {
            if (curr.data.equals(booking)) {
                prev.next = curr.next;
                found = true;
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        if (!found) {
            System.out.println(booking + " not found");
        }
        return head;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("=== Question 4: Cancel a Booking ===");
        String[] bookings = {"104", "101", "107", "101"};
        Node head = new Node(bookings[0]);
        Node curr = head;
        for (int i = 1; i < bookings.length; i++) {
            curr.next = new Node(bookings[i]);
            curr = curr.next;
        }

        head = removeFirst(head, "101");
        printList(head); // 104 -> 107 -> 101 -> null
    }
}
