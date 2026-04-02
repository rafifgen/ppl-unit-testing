package com.praktikum.ppl;

import java.util.Scanner;

/**
 * Main Application - Pengolahan Nilai Mahasiswa
 *
 * Aplikasi ini mengelola proses pengolahan nilai mahasiswa secara interaktif.
 * Modul yang digunakan:
 *   - ValidasiData       : memvalidasi input nilai
 *   - HitungNilaiAkhir   : menghitung nilai akhir berdasarkan bobot
 *   - PenentuanGrade     : menentukan grade (A/B/C/D/E)
 *   - PenentuanKelulusan : menentukan status lulus / tidak lulus
 */
public class MainApp {

    // Inisialisasi semua modul
    private static final ValidasiData       validasiData       = new ValidasiData();
    private static final HitungNilaiAkhir   hitungNilaiAkhir   = new HitungNilaiAkhir();
    private static final PenentuanGrade     penentuanGrade     = new PenentuanGrade();
    private static final PenentuanKelulusan penentuanKelulusan = new PenentuanKelulusan();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        tampilkanHeader();

        // Loop menu utama
        while (running) {
            tampilkanMenu();
            System.out.print("Pilih menu : ");
            String pilihanInput = scanner.nextLine().trim();

            switch (pilihanInput) {
                case "1":
                    prosesInputNilai(scanner);
                    break;
                case "2":
                    System.out.println("\n  Terima kasih! Program selesai.");
                    System.out.println("=============================================");
                    running = false;
                    break;
                default:
                    System.out.println("\n  [!] Pilihan tidak valid. Masukkan angka 1 atau 2.\n");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Menampilkan header aplikasi.
     */
    private static void tampilkanHeader() {
        System.out.println("=============================================");
        System.out.println("   SISTEM PENGOLAHAN NILAI MAHASISWA");
        System.out.println("   Praktikum PPL - Unit Testing");
        System.out.println("=============================================");
    }

    /**
     * Menampilkan menu utama.
     */
    private static void tampilkanMenu() {
        System.out.println("\n---------------------------------------------");
        System.out.println("  MENU UTAMA");
        System.out.println("---------------------------------------------");
        System.out.println("  1. Input Nilai Mahasiswa");
        System.out.println("  2. Keluar");
        System.out.println("---------------------------------------------");
    }

    /**
     * Mengelola proses input nilai mahasiswa.
     * Memanggil modul ValidasiData secara berulang hingga data valid,
     * kemudian memanggil modul-modul komputasi dan menampilkan hasilnya.
     *
     * @param scanner objek Scanner untuk membaca input pengguna
     */
    private static void prosesInputNilai(Scanner scanner) {
        System.out.println("\n  --- INPUT NILAI MAHASISWA ---");

        double nilaiTugas = 0, nilaiUts = 0, nilaiUas = 0;
        boolean dataValid = false;

        // Loop input: ulangi selama data tidak valid
        while (!dataValid) {
            nilaiTugas = bacaNilai(scanner, "  Nilai Tugas (0-100) : ");
            nilaiUts   = bacaNilai(scanner, "  Nilai UTS   (0-100) : ");
            nilaiUas   = bacaNilai(scanner, "  Nilai UAS   (0-100) : ");

            // Panggil modul ValidasiData
            dataValid = validasiData.validasi(nilaiTugas, nilaiUts, nilaiUas);

            if (!dataValid) {
                System.out.println("\n  [!] Data tidak valid!");
                System.out.println("      - Pastikan semua nilai berada di rentang 0-100.");
                System.out.println("      - Nilai tidak boleh semuanya 0 (dianggap belum diisi).");
                System.out.println("  Silakan input ulang.\n");
            }
        }

        // Panggil modul HitungNilaiAkhir
        double nilaiAkhir = hitungNilaiAkhir.hitung(nilaiTugas, nilaiUts, nilaiUas);

        if (nilaiAkhir == -1) {
            System.out.println("\n  [!] Terjadi kesalahan saat menghitung nilai akhir.");
            return;
        }

        // Panggil modul PenentuanGrade
        String grade = penentuanGrade.tentukanGrade(nilaiAkhir);

        // Panggil modul PenentuanKelulusan
        String statusKelulusan = penentuanKelulusan.tentukanKelulusan(nilaiAkhir);

        // Tampilkan hasil
        tampilkanHasil(nilaiTugas, nilaiUts, nilaiUas, nilaiAkhir, grade, statusKelulusan);
    }

    /**
     * Membaca input nilai numerik dari pengguna.
     * Akan terus meminta input jika format tidak valid (bukan angka).
     *
     * @param scanner objek Scanner
     * @param prompt  teks yang ditampilkan sebelum input
     * @return nilai numerik yang dimasukkan pengguna
     */
    private static double bacaNilai(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input harus berupa angka. Coba lagi.");
            }
        }
    }

    /**
     * Menampilkan hasil pengolahan nilai mahasiswa.
     *
     * @param tugas   nilai tugas
     * @param uts     nilai UTS
     * @param uas     nilai UAS
     * @param akhir   nilai akhir hasil perhitungan
     * @param grade   grade yang diperoleh
     * @param status  status kelulusan
     */
    private static void tampilkanHasil(double tugas, double uts, double uas,
                                        double akhir, String grade, String status) {
        System.out.println("\n=============================================");
        System.out.println("  HASIL PENGOLAHAN NILAI");
        System.out.println("=============================================");
        System.out.printf("  Nilai Tugas  (30%%) : %.2f%n", tugas);
        System.out.printf("  Nilai UTS    (30%%) : %.2f%n", uts);
        System.out.printf("  Nilai UAS    (40%%) : %.2f%n", uas);
        System.out.println("---------------------------------------------");
        System.out.printf("  Nilai Akhir        : %.2f%n", akhir);
        System.out.printf("  Grade              : %s%n", grade);
        System.out.printf("  Status Kelulusan   : %s%n", status);
        System.out.println("=============================================");
    }
}
