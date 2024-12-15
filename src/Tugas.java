public class Tugas {
    String Matkul;
    String NamaTugas;
    String deadline;
    String status;
    Tugas next;

    Tugas(String Matkul, String name, String deadline) {
        this.Matkul = Matkul;
        this.NamaTugas = name;
        this.deadline = deadline;
        this.status = "Belum Dikerjakan";
        this.next = null;
    }
}
