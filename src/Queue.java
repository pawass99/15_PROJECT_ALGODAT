class Queue {
    private class Node {
        Tugas tugas;
        Node next;

        Node(Tugas tugas) {
            this.tugas = tugas;
            this.next = null;
        }
    }
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    public void enqueue(Tugas tugas) {
        Node newNode = new Node(tugas);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    public Tugas dequeue() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
            return null;
        }
        Tugas tugas = front.tugas;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return tugas;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public int getSize() {
        return size;
    }
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Tidak ada tugas yang sedang dikerjakan.");
            return;
        }
        System.out.println("\nTugas yang Sedang Dikerjakan:");
        System.out.println("=============================");
        Node current = front;
        int count = 1;
        while (current != null) {
            System.out.println(count++ + ". " + current.tugas.nama +
                " (Deadline: " + current.tugas.deadline + 
                ", Status: " + current.tugas.status + ")");
            current = current.next;
        }        
        System.out.println("=============================");
    }
}