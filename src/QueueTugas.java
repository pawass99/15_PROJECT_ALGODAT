public class QueueTugas {
    Tugas front;
    Tugas rear;

    void enqueue(Tugas task) {
        if (rear == null) {
            front = rear = task;
        } else {
            rear.next = task;
            rear = task;
        }
    }

    Tugas dequeue() {
        if (front == null) {
            System.out.println("Queue kosong.");
            return null;
        }

        Tugas task = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return task;
    }

    boolean isEmpty() {
        return front == null;
    }
}