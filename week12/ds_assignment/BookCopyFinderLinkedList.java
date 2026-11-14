public class BookCopyFinderLinkedList {

    public static class Node {
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static String find(Node head, String id) {
        int pos = 1;
        int firstPos = -1;
        int copies = 0;

        Node curr = head;
        while (curr != null) {
            if (curr.data.equals(id)) {
                if (firstPos == -1) {
                    firstPos = pos;
                }
                copies++;
            }
            pos++;
            curr = curr.next;
        }

        if (firstPos != -1) {
            return String.format("%s first at position %d, copies: %d", id, firstPos, copies);
        } else {
            return id + " not found";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Question 3: Book Copy Finder ===");
        String[] ids = {"B12", "B07", "B30", "B07", "B45", "B07"};
        Node head = new Node(ids[0]);
        Node curr = head;
        for (int i = 1; i < ids.length; i++) {
            curr.next = new Node(ids[i]);
            curr = curr.next;
        }

        System.out.println(find(head, "B07"));
        System.out.println(find(head, "B99"));
    }
}
