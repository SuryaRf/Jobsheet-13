import java.util.Scanner;

public class Kubus27 {
    public static void main(String[] args) {
        Scanner sc27 = new Scanner(System.in);
        System.out.print("Masukan sisi: ");
        int sisi = sc27.nextInt();

        int volume = hitungVolume(sisi);

        System.out.println("Volume kubus adalah " + volume);
    }

    public static int hitungVolume(int sisi) {
        return sisi * sisi * sisi;
    }
}

