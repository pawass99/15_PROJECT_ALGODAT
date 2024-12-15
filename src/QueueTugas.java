public class QueueTugas {
    Tugas front;
    Tugas rear;
    StackTugas stack = new StackTugas();

    void enqueue(String Matkul, String NamaTugas, String deadline) {
        Tugas tugas = new Tugas(Matkul, NamaTugas, deadline);
        if (rear == null) {
            front = rear = tugas;
        } else {
            rear.next = tugas;
            rear = tugas;
        }
        System.out.println("Tugas " + tugas.NamaTugas + " berhasil ditambahkan.");
    }

    Tugas dequeue() {
        if (front == null) {
            System.out.println("Queue kosong.");
            return null;
        }
        Tugas tugas = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return tugas;
    }
    Tugas dequeuePilih(String target) {
        if (front == null) {
            System.out.println("Queue kosong.");
            return null;
        }
        Tugas tugas = front;
        if (tugas.NamaTugas.equals(target)) {
            front = front.next;
            if (front == null) {
                rear = null;
            }
            // System.out.println("Tugas " + tugas.NamaTugas + " berhasil dihapus.");
            return tugas;
        }
        Tugas temp = front;
        while (temp.next != null) {
            if (temp.next.NamaTugas.equals(target)) {
                tugas = temp.next;
                temp.next = temp.next.next;
                if (temp.next == null) {
                    rear = temp;
                }
                // System.out.println("Tugas " + tugas.NamaTugas + " berhasil dihapus.");
                return tugas;
            }
            temp = temp.next;
        }
        return null;
    }

    boolean isEmpty() {
        return front == null;
    }

    void tampilkanBelumDikerjakan() {
        Tugas temp = front;
        int i = 1;
        while (temp!= null) {
            if (temp.status.equals("Belum Dikerjakan")) {
                System.out.println("===================================");
                System.out.println(i + " Mata Kuliah: " + temp.Matkul);
                System.out.println("  Nama Tugas: " + temp.NamaTugas);
                System.out.println("  Deadline: " + temp.deadline);
                System.out.println("  Status: " + temp.status);
                i++;
            }
            temp = temp.next;
        }
        System.out.println("===================================");
        if (i == 1) {
            System.out.println("Tidak ada tugas yang belum dikerjakan.");
        }
    }
}