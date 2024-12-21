import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree("");
        Stack history = new Stack();
        LinkedList nilai = new LinkedList();
        Queue queue = new Queue();

        while (true) {
            System.out.println("\n===================================");
            System.out.println("  _   _                       ");
            System.out.println(" | \\ | |_   _  __ _  __ _ ___ ");
            System.out.println(" |  \\| | | | |/ _ |/ _ / __|");
            System.out.println(" | |\\  | |_| | (_| | (_| \\__ \\");
            System.out.println(" |_| \\_|\\__,_|\\__, |\\__,_|___/");
            System.out.println("              |___/           ");
            System.out.println("===================================");
            System.out.println("1. Tambah");
            System.out.println("2. Lihat");
            System.out.println("3. Update");
            System.out.println("4. Exit");
            System.out.print("Pilih opsi = ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    while (true) {
                        System.out.println("===================================");
                        System.out.println("1. Tambah Semester");
                        System.out.println("2. Tambah Matkul");
                        System.out.println("3. Tambah Tugas");
                        System.out.println("4. Kembali");
                        System.out.print("Pilih opsi = ");
                        int subPilihan = scanner.nextInt();
                        scanner.nextLine();

                        if (subPilihan == 4) break;

                        switch (subPilihan) {
                            case 1:
                                System.out.print("Masukkan Nama Semester: ");
                                String semester = scanner.nextLine();
                                tree.addChild("", semester);
                                break;
                            case 2:
                                System.out.print("Masukkan Semester: ");
                                String parentSemester = scanner.nextLine();
                                System.out.print("Masukkan Nama Matkul: ");
                                String matkul = scanner.nextLine();
                                tree.addChild(parentSemester, matkul);
                                break;
                            case 3:
                                System.out.print("Masukkan Matkul: ");
                                String parentMatkul = scanner.nextLine();
                                System.out.print("Masukkan Nama Tugas: ");
                                String namaTugas = scanner.nextLine();
                                System.out.print("Masukkan Deadline (YYYY-MM-DD): ");
                                String deadline = scanner.nextLine();
                                tree.addTask(parentMatkul, namaTugas, deadline, "Belum Dikerjakan");
                                break;
                            default:
                                System.out.println("Opsi Tidak Valid");
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("===================================");
                        System.out.println("1. Lihat Pohon Tugas");
                        System.out.println("2. Lihat History");
                        System.out.println("3. Lihat Nilai Tugas");
                        System.out.println("4. Lihat Tugas yang Sedang Dikerjakan");
                        System.out.println("5. Kembali");
                        System.out.print("Pilih opsi = ");
                        int subPilihan = scanner.nextInt();
                        scanner.nextLine();

                        if (subPilihan == 5) break;

                        switch (subPilihan) {
                            case 1:
                                tree.printTree(tree.root, "", true);
                                break;
                            case 2:
                                history.printHistory();
                                break;
                            case 3:
                                nilai.printNilai();
                                break;
                            case 4:
                                tree.printIncompleteTasks();
                                break;
                            default:
                                System.out.println("Opsi Tidak Valid");
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        System.out.println("===================================");
                        System.out.println("1. Update Status Tugas");
                        System.out.println("2. Tandai Tugas Selesai");
                        System.out.println("3. Kembali");
                        System.out.print("Pilih opsi = ");
                        int subPilihan = scanner.nextInt();
                        scanner.nextLine();

                        if (subPilihan == 3) break;

                        switch (subPilihan) {
                            case 1:
                                System.out.print("Masukkan Nama Tugas: ");
                                String namaTugas = scanner.nextLine();
                                System.out.print("Masukkan Status Baru: ");
                                String statusBaru = scanner.nextLine();
                                tree.updateTaskStatus(namaTugas, statusBaru);
                                break;
                            case 2:
                                System.out.print("Masukkan Nama Tugas: ");
                                String namaTarget = scanner.nextLine();
                                Tugas tuntas = queue.dequeue();
                                if (tuntas != null && tuntas.nama.equals(namaTarget)) {
                                    tuntas.status = "Sudah Dikerjakan";
                                    history.push(tuntas);
                                    System.out.println("Tugas berhasil ditandai tuntas dan dipindahkan ke history.");
                                } else {
                                    System.out.println("Tugas tidak ditemukan di antrian.");
                                }
                                break;
                            default:
                                System.out.println("Opsi Tidak Valid");
                        }
                    }
                    break;

                case 4:
                    scanner.close();
                    return;

                default:
                    System.out.println("Opsi Tidak Valid");
            }
        }
    }
}