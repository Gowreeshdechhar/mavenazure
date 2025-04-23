import java.util.Scanner;

class CircularQueue {
    private int[] queue; // Array to store elements
    private int front, rear, size, capacity; // Tracking variables

    // Constructor to initialize queue
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = -1; // Initially, queue is empty
        this.rear = -1;
        this.size = 0;
    }

    // Enqueue: Add element to queue
    public void enqueue(int value) {
        if ((rear + 1) % capacity == front) { // Check if full
            System.out.println("Queue is full! Cannot insert " + value);
            return;
        }
        if (front == -1) { // If queue was empty, set front to 0
            front = 0;
        }
        rear = (rear + 1) % capacity; // Move rear to next position (circular)
        queue[rear] = value;
        size++;
        System.out.println("Inserted: " + value);
    }

    // Dequeue: Remove element from queue
    public int dequeue() {
        if (front == -1) { // Check if empty
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        int removedValue = queue[front]; // Get front element
        if (front == rear) { // If only one element left
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity; // Move front to next position (circular)
        }
        size--;
        System.out.println("Removed: " + removedValue);
        return removedValue;
    }

    // Display queue
    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break; // Stop when rear is reached
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    // Check if queue is full
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for queue capacity
        System.out.print("Enter queue capacity: ");
        int capacity = scanner.nextInt();
        CircularQueue queue = new CircularQueue(capacity);

        while (true) {
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
