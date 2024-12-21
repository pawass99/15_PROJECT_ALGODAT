class Tugas {
    String nama;
    String deadline;
    String status;
    double nilai;
    Tugas firstChild;
    Tugas nextSibling;

    Tugas(String nama) {
        this.nama = nama;
        this.deadline = null;
        this.status = "Belum Dikerjakan";
        this.firstChild = null;
        this.nextSibling = null;
    }

    Tugas(String nama, String deadline, String status) {
        this.nama = nama;
        this.deadline = deadline;
        this.status = status;
        this.firstChild = null;
        this.nextSibling = null;
    }

}
