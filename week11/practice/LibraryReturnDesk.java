public class LibraryReturnDesk {

    public static class BookStack {
        private String[] stack = new String[3];
        private int top = -1;

        public void push(String book) {
            if (top == stack.length - 1) {
                System.out.println(book + " rejected: pile is full");
            } else {
                stack[++top] = book;
                System.out.println(book + " placed on pile");
            }
        }

        public void pop() {
            if (top == -1) {
                System.out.println("pile is empty");
            } else {
                System.out.println("shelved " + stack[top--]);
            }
        }
    }

    public static class StudentQueue {
        private String[] queue = new String[3];
        private int front = 0;
        private int rear = 0;
        private int size = 0;

        public void enqueue(String student) {
            if (size == queue.length) {
                System.out.println("line is full");
            } else {
                queue[rear] = student;
                rear = (rear + 1) % queue.length;
                size++;
                System.out.println(student + " joined the line");
            }
        }

        public void dequeue() {
            if (size == 0) {
                System.out.println("no one waiting");
            } else {
                String s = queue[front];
                front = (front + 1) % queue.length;
                size--;
                System.out.println("served " + s);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Library Return Desk ===");
        BookStack pile = new BookStack();
        StudentQueue line = new StudentQueue();

        pile.push("B1");
        pile.push("B2");
        pile.push("B3");
        pile.push("B4"); // Full

        line.enqueue("Asha");
        line.enqueue("Ravi");

        pile.pop();
        line.dequeue();

        pile.pop();
        pile.pop();
        pile.pop(); // Empty

        line.dequeue();
        line.dequeue(); // Empty
    }
}
