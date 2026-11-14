public class LateComersQueueLinkedList {

    public static class Node {
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    public static Node addLast(Node head, String name) {
        Node newNode = new Node(name);
        if (head == null) return newNode;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    public static void printLine(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("=== Question 2: Late Comers in the Line ===");
        // Sample 1: Asha -> Ravi
        Node line = new Node("Asha");
        line.next = new Node("Ravi");

        line = addFirst(line, "Neha");
        line = addLast(line, "Kiran");
        line = addFirst(line, "Mohan");

        printLine(line); // Mohan -> Neha -> Asha -> Ravi -> Kiran -> null
    }
}
