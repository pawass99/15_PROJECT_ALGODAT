import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueTugas queue = new QueueTugas();
        StackTugas stack = new StackTugas();

        while(true){
            System.out.println("\n===================================");
            System.out.println("  _   _                       ");
            System.out.println(" | \\ | |_   _  __ _  __ _ ___ ");
            System.out.println(" |  \\| | | | |/ _` |/ _` / __|");
            System.out.println(" | |\\  | |_| | (_| | (_| \\__ \\");
            System.out.println(" |_| \\_|\\__,_|\\__, |\\__,_|___/");
            System.out.println("              |___/           ");
            System.out.println("===================================");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Lihat Tugas");
            System.out.println("3. Edit Tugas");
            System.out.println("4. Update Status Tugas");
            System.out.println("5. Lihat Tugas Tuntas");
            System.out.println("6. Urutkan Tugas berdasarkan Deadline");
            System.out.println("7. Exit");
            System.out.print("Pilih opsi = ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan){
                case 1:
                    System.out.println("===================================");
                    System.out.print("Masukkan Mata Kuliah: ");
                    String Matkul = scanner.nextLine();
                    System.out.print("Masukkan Nama Tugas: ");
                    String NamaTugas = scanner.nextLine();
                    System.out.print("Masukkan Deadline (YYYY-MM-DD): ");
                    String deadline = scanner.nextLine();
                    queue.enqueue(Matkul, NamaTugas, deadline);
                    break;
                case 2:
                    queue.tampilkanBelumDikerjakan();
                    break;
                case 3:
                    System.out.println("===================================");
                    System.out.print("Masukkan Nama Tugas: ");
                    String namaTugas = scanner.nextLine();
                    if (queue.cekTugas(namaTugas)) System.out.println("Tugas Ditemukan!");
                    else {
                        System.out.println("Tugas Tidak Ditemukan!");
                        break;
                    }
                    System.out.println("===================================");
                    System.out.println("(kosongkan jika tidak diubah)");
                    System.out.print("Masukkan Nama Tugas Baru: ");
                    String newNamaTugas = scanner.nextLine();
                    System.out.print("Masukkan Mata Kuliah Baru: ");
                    String newMatkul = scanner.nextLine();
                    System.out.print("Masukkan Deadline Baru (YYYY-MM-DD): ");
                    String newDeadline = scanner.nextLine();
                    queue.editTugas(namaTugas, newNamaTugas, newMatkul, newDeadline);
                    break;
                case 4:
                    System.out.println("===================================");
                    System.out.print("Masukkan Nama Tugas: ");
                    String namaTarget = scanner.nextLine();
                    Tugas tuntas = queue.dequeuePilih(namaTarget);
                    if (tuntas != null) {
                        tuntas.status = "Sudah Dikerjakan";
                        stack.push(tuntas);
                        System.out.println("Tugas berhasil ditandai tuntas dan dipindahkan ke history.");
                    } else {
                        System.out.println("Tugas tidak ditemukan di antrian.");
                    }
                    break;
                case 5:
                    stack.tampilHistory();
                    break;
                case 6:
                    queue.sort();
                    break;
                case 7:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi Tidak Valid");
            }
        }
    }
}