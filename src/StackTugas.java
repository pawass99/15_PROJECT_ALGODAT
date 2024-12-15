public class StackTugas {
    Tugas top;
    
    public void push(Tugas baru) {
        if (top == null) {
            top = baru;
            // System.out.println("Tugas " + tugas.NamaTugas + " berhasil dimasukkan ke Stack");
            return;
        }
        baru.next = top;
        top = baru;
        // System.out.println("Tugas " + tugas.NamaTugas + " berhasil ditambahkan ke History");
    }

    Tugas pop() {
        if (top == null) {
            System.out.println("Stack kosong");
            return null;
        }
        Tugas tugas = top;
        top = top.next;
        return tugas;
    }

    void tampilHistory(){
        Tugas temp = top;
        int i = 1;
        System.out.println("===================================");
        while (temp != null) {
            System.out.println(i + " Mata Kuliah: " + temp.Matkul);
            System.out.println("  Nama Tugas: " + temp.NamaTugas);
            System.out.println("  Deadline: " + temp.deadline);
            System.out.println("  Status: " + temp.status);
            System.out.println("===================================");
            i++; temp = temp.next;
        }
        if (i == 1) {
            System.out.println("History Kosong");
        }
    }
}
