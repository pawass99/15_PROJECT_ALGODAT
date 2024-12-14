import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("  _   _                       ");
        System.out.println(" | \\ | |_   _  __ _  __ _ ___ ");
        System.out.println(" |  \\| | | | |/ _` |/ _` / __|");
        System.out.println(" | |\\  | |_| | (_| | (_| \\__ \\");
        System.out.println(" |_| \\_|\\__,_|\\__, |\\__,_|___/");
        System.out.println("              |___/           ");
        System.out.println("===================================");

        while(true){
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Lihat Tugas");
            System.out.println("3. Update Status Tugas");
            System.out.println("4. Exit");
            System.out.println("Pilih opsi");   
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch(pilihan){
                case 1:
                    //Lanjut method tambah tugas
                    break;
                case 2:
                    //Lanjut method lihat tugas
                case 3:
                    //Lanjut method update status
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi Tidak Valid");
            }
        }
    }
}