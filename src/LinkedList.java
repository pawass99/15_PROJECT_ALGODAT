public class LinkedList {
    private class Node {
        String namaTugas;
        double nilai;
        Node next;

        Node(String namaTugas, double nilai) {
            this.namaTugas = namaTugas;
            this.nilai = nilai;
            this.next = null;
        }
    }

    Node head;
    int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addNilai(String namaTugas, double nilai) {
        Node newNode = new Node(namaTugas, nilai);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public void addNilaiFromTugas(Tugas tugas) {
        if (tugas != null && tugas.status.equals("Selesai")) {
            addNilai(tugas.nama, tugas.nilai);
        }
        if (tugas.firstChild != null) {
            addNilaiFromTugas(tugas.firstChild);
        }
        if (tugas.nextSibling != null) {
            addNilaiFromTugas(tugas.nextSibling);
        }
    }
    public void printNilai() {
        if (head == null) {
            System.out.println("Belum ada data nilai tugas.");
            return;
        }
        System.out.println("\nDaftar Nilai Tugas:");
        System.out.println("===================");
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count++ + ". " + current.namaTugas + ": " + Double.toString(current.nilai));
            current = current.next;
        }
        System.out.println("===================");
    }    
    public void sortNilaiDescending() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current != null && current.next != null) {
                if (current.nilai < current.next.nilai) {
                    double tempNilai = current.nilai;
                    String tempNamaTugas = current.namaTugas;

                    current.nilai = current.next.nilai;
                    current.namaTugas = current.next.namaTugas;

                    current.next.nilai = tempNilai;
                    current.next.namaTugas = tempNamaTugas;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
