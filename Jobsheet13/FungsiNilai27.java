import java.util.Scanner;

public class FungsiNilai27 {
    static final int jumlahMinggu = 7;
    static final int jumlahMahasiswa = 5;

    static String[] namaMahasiswa = {"Sari", "Rina", "Yani", "Dwi", "Lusi"};
    static int[][] nilaiMahasiswa = new int[jumlahMahasiswa][jumlahMinggu];

    public static void main(String[] args) {
        inputDataNilaiMahasiswa();
        tampilkanNilaiMahasiswa();
        cariHariNilaiTertinggi();
        tampilkanMahasiswaNilaiTertinggi();
    }

    static void inputDataNilaiMahasiswa() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Masukkan nilai tugas " + namaMahasiswa[i] + " per minggu:");
            for (int j = 0; j < jumlahMinggu; j++) {
                System.out.print("Minggu ke-" + (j + 1) + ": ");
                nilaiMahasiswa[i][j] = scanner.nextInt();
            }
        }
        System.out.println("");
    }

    static void tampilkanNilaiMahasiswa() {
        System.out.println("Nilai Mahasiswa:");
        System.out.print("Minggu\t");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.print(namaMahasiswa[i] + "\t");
        }
        System.out.println();

        for (int j = 0; j < jumlahMinggu; j++) {
            System.out.print("Minggu ke-" + (j + 1) + "\t");
            for (int i = 0; i < jumlahMahasiswa; i++) {
                System.out.print(nilaiMahasiswa[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("");
    }

    static void cariHariNilaiTertinggi() {
        int hariTertinggi = 0;
        int nilaiTertinggi = 0;

        for (int j = 0; j < jumlahMinggu; j++) {
            int totalNilaiMinggu = 0;
            for (int i = 0; i < jumlahMahasiswa; i++) {
                totalNilaiMinggu += nilaiMahasiswa[i][j];
            }
            if (totalNilaiMinggu > nilaiTertinggi) {
                nilaiTertinggi = totalNilaiMinggu; hariTertinggi = j + 1;
            }
        }

        System.out.println("Hari dengan nilai tertinggi adalah Minggu ke-" + hariTertinggi);
        System.out.println("");
    }

    static void tampilkanMahasiswaNilaiTertinggi() {
        System.out.println("Mahasiswa dengan nilai tertinggi:");

        int nilaiTertinggi = 0;
        int indexMahasiswa = 0;
        

        for (int i = 0; i < jumlahMahasiswa; i++) {
            int totalNilaiMahasiswa = 0;
            for (int j = 0; j < jumlahMinggu; j++) {
                totalNilaiMahasiswa += nilaiMahasiswa[i][j];
            }
            if (totalNilaiMahasiswa > nilaiTertinggi) {
                nilaiTertinggi = totalNilaiMahasiswa;
                indexMahasiswa = i;
            }
        }

        System.out.println(namaMahasiswa[indexMahasiswa] + " memiliki nilai tertinggi sebesar " + nilaiTertinggi);

        System.out.println("Rincian nilai per minggu:");
        for (int j = 0; j < jumlahMinggu; j++) {
            System.out.println("Minggu ke-" + (j + 1) + ": " + nilaiMahasiswa[indexMahasiswa][j]);
        }
        System.out.println("");
    }
    
}
