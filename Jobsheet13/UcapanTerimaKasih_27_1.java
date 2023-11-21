
import java.util.Scanner;

public class UcapanTerimaKasih_27_1 {
    public static String PenerimaUcapan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tuliskan NAMA orang yang ingin Anda beri ucapan:");
        String namaOrang = sc.nextLine();

        return namaOrang;
    }

    public static void UcapanTerimaKasih() {
        String nama = PenerimaUcapan();
        String ucapan = UcapanTambahan();
        System.out.println("Thank you " + nama + " for being the best teacher in the world.\n"
                + "You inspired in me a love for learning and made me feel like I could ask you anything.");
        System.out.println("ini adalah ucapan tambahan : " + ucapan);

    }

    public static String UcapanTambahan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukan ucapan tambahan yang ingin diberikan:");
        String ucapanTambahan = sc.nextLine();

        return ucapanTambahan;
    }

    public static void main(String[] args) {
        UcapanTerimaKasih();
    }
}
