public class PlateStackLinkedList {

    public static class Node {
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class PlateStack {
        private Node top = null;
        private int size = 0;

        public void push(String plate) {
            Node newNode = new Node(plate);
            newNode.next = top;
            top = newNode;
            size++;
            System.out.printf("push %s -> top %s, size %d%n", plate, top.data, size);
        }

        public void pop() {
            if (isEmpty()) {
                System.out.println("pop -> stack is empty");
                return;
            }
            String removed = top.data;
            top = top.next;
            size--;
            System.out.printf("pop -> %s, size %d%n", removed, size);
        }

        public void peek() {
            if (isEmpty()) {
                System.out.println("peek -> stack is empty");
            } else {
                System.out.println("peek -> " + top.data);
            }
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Question 5: Plate Stack on a Chain ===");
        PlateStack stack = new PlateStack();
        stack.push("P1");
        stack.push("P2");
        stack.peek();
        stack.pop();
        stack.push("P3");
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("isEmpty -> " + stack.isEmpty());
    }
}
