import java.util.Date;
import java.util.Scanner;

public class FungsiKel3_27 {
    static Scanner sc = new Scanner(System.in);
    static Date tanggal = new Date();
    static String[][] userMain = { { "admin", "karyawan" }, { "123", "456" } };
    static String[][] getUser = new String[2][2];
    static boolean menuProcess, mainProcess, validationAdmin, validationKaryawan;
    static int menu;
    static String[] nama = new String[100];
    static int hitungPegawai, gajiPokok, tunjangan, lembur = 10000, gajiLembur, pajak = 0;
    static int[] totalGaji = new int[100];
    static String[] gender = new String[100];
    static int[] age = new int[100];
    static int[] id = new int[500];
    static String jenisK;
    static String status, yesNo, jK;
    static String golongan[] = new String[100];
    static String alamat[] = new String[100];
    static String jenisKelamin[] = new String[100];
    static int jamLembur[] = new int[100];

    static boolean validationAdmin(String username, String password) {
        return username.equals(userMain[0][0]) && password.equals(userMain[1][0]);
    }

    // validation Karyawan function
    static boolean validationKaryawan(String username, String password) {
        return username.equals(userMain[0][1]) && password.equals(userMain[1][1]);
    }

    static void loginPageAdmin() {
        System.out.println("===============================================================");
        System.out.println("                         * LOGIN *                             ");
        System.out.println("===============================================================");

        System.out.print("Masukan Username : ");
        getUser[0][0] = sc.nextLine();
        System.out.print("Masukan Password : ");
        getUser[1][0] = sc.nextLine();
        validationAdmin = validationAdmin(getUser[0][0], getUser[1][0]);

    }

    // login page karywan
    static void loginKaryawan() {
        validationKaryawan = validationKaryawan(getUser[0][0], getUser[1][0]);
    }

    static void employeeData() {
        int kode = 0;
        do {
            System.out.println();
            System.out.println("============================================");
            System.out.println("              Employee Data Menu            ");
            System.out.println("============================================");
            System.out.println();
            System.out.println("[1] Input Employee Data ");
            System.out.println("[2] Show Employee Data ");
            System.out.println("[3] Edit Employee Data ");
            System.out.println("[4] Total Employee Data ");
            System.out.println("[5] Back ");
            System.out.print("Enter Choice\t: ");
            kode = sc.nextInt();
            sc.nextLine();
            if (kode == 1) {
                for (int j = 0; true; j++) {
                    System.out.print("Employee Name\t: ");
                    nama[j] = sc.nextLine();
                    System.out.print("Number ID\t: ");
                    id[j] = sc.nextInt();
                    System.out.print("Gender (M/F)\t: ");
                    sc.nextLine();
                    String jenisK = sc.nextLine();
                    System.out.print("Age\t\t: ");
                    age[j] = sc.nextInt();
                    System.out.print("Address\t\t: ");
                    sc.nextLine();
                    alamat[j] = sc.nextLine();

                    System.out.println("For Classes :");
                    System.out.println("A = Part-time Employees");
                    System.out.println("B = Internship");
                    System.out.println("C = Permanent Staff");
                    System.out.println("D = Manager");

                    System.out.print("Class Input (A-D): ");
                    golongan[j] = sc.nextLine();
                    System.out.print("Input Overtime Time (Hours): ");
                    jamLembur[j] = sc.nextInt();
                    System.out.print("Continue ? (Y/N)\t:");
                    String lanjut = sc.nextLine();
                    lanjut = sc.nextLine();

                    if (jenisK.equalsIgnoreCase("f")) {
                        jenisKelamin[j] = "Perempuan";
                    } else if (jenisK.equalsIgnoreCase("m")) {
                        jenisKelamin[j] = "Laki-laki";
                    }
                    if (lanjut.equalsIgnoreCase("n")) {
                        break;
                    }

                    hitungPegawai++;
                }
            }
            if (kode == 2) {
                for (int i = 0; i <= hitungPegawai; i++) {

                    System.out.println("+---------------------------------+");
                    System.out.println("Employee Name\t: " + nama[i]);
                    System.out.println("Class Employee\t: " + golongan[i]);
                    System.out.println("Number ID\t: " + id[i]);
                    System.out.println("Gender\t\t: " + jenisKelamin[i]);
                    System.out.println("Addres\t\t: " + alamat[i]);
                    System.out.println("Age\t\t: " + age[i]);
                    System.out.println("+---------------------------------+");
                }
            } else if (kode == 3) {
                System.out.print("Enter Employee Name : ");
                String nama2 = sc.nextLine();
                for (int i = 0; i <= hitungPegawai; i++) {
                    if (nama[i].equalsIgnoreCase(nama2)) {
                        System.out.print("Employee Name\t: ");
                        nama[i] = sc.nextLine();
                        System.out.print("Number ID: ");
                        id[i] = sc.nextInt();
                        System.out.print("Gender (M/F) : ");
                        jenisK = sc.nextLine();
                        sc.nextLine();
                        System.out.print("Age : ");
                        age[i] = sc.nextInt();
                        System.out.print("Address : ");
                        sc.nextLine();
                        alamat[i] = sc.nextLine();
                        System.out.println("For Classes :");
                        System.out.println("A = Part-time Employees");
                        System.out.println("B = Internship");
                        System.out.println("C = Permanent Staff");
                        System.out.println("D = Manager");

                        System.out.print("Class Input (A-D) : ");
                        golongan[i] = sc.nextLine();
                        System.out.print("Input Overtime Time (Hours) : ");
                        jamLembur[i] = sc.nextInt();

                        if (jenisK.equalsIgnoreCase("f")) {
                            jenisKelamin[i] = "Perempuan";
                        } else if (jenisK.equalsIgnoreCase("m")) {
                            jenisKelamin[i] = "Laki-laki";
                        }

                        break;
                    } else if (i == hitungPegawai) {
                        System.out.println("\u001b[31mThe Name You Entered is Not Registered!\u001b[0m");
                    }
                }
            } else if (kode == 4) {
                int paruhWaktu = 0, magang = 0, tetap = 0, manajer = 0;
                for (int i = 0; i <= hitungPegawai; i++) {
                    if (golongan[i].equalsIgnoreCase("a")) {
                        paruhWaktu++;
                    } else if (golongan[i].equalsIgnoreCase("b")) {
                        magang++;
                    } else if (golongan[i].equalsIgnoreCase("c")) {
                        tetap++;
                    } else if (golongan[i].equalsIgnoreCase("d")) {
                        manajer++;
                    }
                }
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("+                 Total Number of Employees                 +");
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("Total Number of Part-Time Employees: " + paruhWaktu + " Person,");
                System.out.println("Total Number of Interns            : " + magang + " Person,");
                System.out.println("Total Number of Permanent Employees: " + tetap + " Person,");
                System.out.println("Total Number of Manager            : " + manajer + " Person,");
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("Total Number of Employees : " + (hitungPegawai + 1) + " Person.");

            }
        } while (kode != 5);
    }

    static void calculateSlry() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+              Employee Salary Calculation +                +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Enter Employee Name : ");
        String nama2 = sc.nextLine();

        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(nama2)) {
                perhitungan(i);
                cekPajak(i);
                System.out.println("Base Salary      : Rp. " + gajiPokok);
                System.out.println("Allowance Money  : RP. " + tunjangan);
                System.out.println("Overtime Salary  : Rp. " + gajiLembur);
                System.out.println("Tax              :     " + pajak + "%");
                System.out.println("Total Salary     : Rp. " + totalGaji[i]);
                break;
            } else if (i == hitungPegawai) {
                System.out.println("\u001b[31mThe Name You Entered is Not Registered!\u001b[0m");
            }
        }
    }

    static void perhitungan(int x) {
        if (golongan[x].equalsIgnoreCase("a")) {
            gajiPokok = 1000000;
            tunjangan = 500000;
        } else if (golongan[x].equalsIgnoreCase("b")) {
            gajiPokok = 1500000;
            tunjangan = 700000;
        } else if (golongan[x].equalsIgnoreCase("c")) {
            gajiPokok = 2000000;
            tunjangan = 900000;
        } else if (golongan[x].equalsIgnoreCase("d")) {
            gajiPokok = 2500000;
            tunjangan = 1200000;
        }

        gajiLembur = jamLembur[x] * lembur;
        totalGaji[x] = (gajiPokok + tunjangan + gajiLembur);

    }

    static void cekPajak(int x) {
        if (totalGaji[x] > 450000) {
            pajak = 5;
        } else if (totalGaji[x] > 1250000) {
            pajak = 15;
        } else if (totalGaji[x] > 2050000) {
            pajak = 25;
        }

        int totalPajak = totalGaji[x] * pajak / 100;
        totalGaji[x] -= totalPajak;
    }

    static void report() {
        int i = 0;
        int pengeluaran = 0;
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                    Salary Expense Report                  +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Date : ");
        System.out.println(tanggal);
        System.out.println();
        System.out.println();

        for (int j = 0; j <= hitungPegawai; j++) {
            perhitungan(j);
            System.out.println("+------------------------------+");
            System.out.println("Employee Name   :     " + nama[j]);
            System.out.println("Gender          :     " + jenisKelamin[j]);
            System.out.println("Employee Class  :     " + golongan[j]);
            System.out.println("Overtime time   :     " + jamLembur[j] + " jam");
            System.out.println("Employee Salary : Rp. " + totalGaji[j]);
            System.out.println("+------------------------------+");
            pengeluaran += totalGaji[j];
        }
        System.out.println("So Total Company Expenses for Salaries of All Employees = Rp. " + pengeluaran);

    }

    static void searching() {
        System.out.println("[1] Search by Name ");
        System.out.println("[2] Search by Employee Number");
        System.out.println("[3] Cancel");
        System.out.print("Enter Choice : ");
        int masukan = sc.nextInt();
        sc.nextLine();
        int cari = 0;

        if (masukan == 1) {
            System.out.print("Enter Employee Name  : ");
            String nama2 = sc.nextLine();
            for (int i = 0; i <= hitungPegawai; i++) {
                if (nama[i].equalsIgnoreCase(nama2)) {
                    System.out.println("       Search Results     ");
                    System.out.println("Employee Name    : " + nama[i]);
                    System.out.println("Class            : " + golongan[i]);
                    System.out.println("Gender           : " + jenisKelamin[i]);
                    System.out.println("Addres           : " + alamat[i]);
                    System.out.println("Age              : " + age[i]);
                    System.out.println("Employee Number  : " + id[i]);
                    break;
                } else if (i == hitungPegawai) {
                    System.out.println("\u001b[31mThe Name You Entered is Not Registered!\u001b[0m");
                }
            }
        } else if (masukan == 2) {
            System.out.print("Enter Employee Number : ");
            cari = sc.nextInt();
            for (int i = 0; i <= hitungPegawai; i++) {
                if (id[i] == cari) {
                    System.out.println("       Search Results      ");
                    System.out.println("Employee Name   : " + nama[i]);
                    System.out.println("Class           : " + golongan[i]);
                    System.out.println("Gender\t: " + jenisKelamin[i]);
                    System.out.println("Addres\t: " + alamat[i]);
                    System.out.println("Age\t: " + age[i]);
                    System.out.println("Employee Number  : " + id[i]);
                }
            }
        }

    }

    public static void main(String[] args) {
        String line = "===============================================================";
        System.out.printf("%s\n\t     SELAMAT DATANG DI SISTEM PENGGAJIAN \n%s", line, line);
        mainProcess = true;
        System.out.println();
        while (mainProcess) {
            // Menambahkan warna dan font
            System.out.println("\u001b[32mSILAHKAN LOGIN UNTUK MELANJUTKAN AKSES PROGRAM\u001b[0m");
            System.out.println("1. Login");
            System.out.println("2. Keluar Program");
            System.out.println();
            System.out.print("Pilih Menu 1 - 2 : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    menuProcess = true;
                    loginPageAdmin();
                    if (validationAdmin) {
                        System.out.println("===============================================================");
                        System.out.println("                     Selamat Datang Admin!");
                        System.out.println("===============================================================");
                        while (menuProcess) {
                            System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
                            System.out.println("|    * MENU OPTIONS *     |");
                            System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
                            System.out.println("| [1] Employee Data       |");
                            System.out.println("| [2] Salary Calculation  |");
                            System.out.println("| [3] Report              |");
                            System.out.println("| [4] Searching           |");
                            System.out.println("| [5] Exit                |");
                            System.out.println("+-------------------------+");
                            System.out.print("Choose Menu 1 - 5 : ");
                            menu = sc.nextInt();
                            sc.nextLine();
                            switch (menu) {
                                case 1:
                                    employeeData();
                                    break;
                                case 2:
                                    calculateSlry();
                                    break;
                                case 3:
                                    report();
                                    break;
                                case 4:
                                    searching();
                                case 5:
                                    menuProcess = false;
                                default:
                                    System.out.println();
                                    System.out.println("\u001b[31mInvalid menu! Choose menu correctly\u001b[0m");
                                    System.out.println();
                                    break;
                            }
                        }

                    }
            }
        }
    }
}
