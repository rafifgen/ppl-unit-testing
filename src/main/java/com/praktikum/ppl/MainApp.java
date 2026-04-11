package com.praktikum.ppl;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main Application — UI Layer
 *
 * Satu-satunya tanggung jawab kelas ini:
 *   1. Menerima input dari pengguna
 *   2. Membungkus input ke dalam objek {@link NilaiMahasiswa}
 *   3. Mendelegasikan seluruh pengolahan ke {@link PengolahNilai}
 *   4. Menampilkan hasil dari objek {@link HasilPengolahan}
 *
 * MainApp tidak mengetahui logika validasi, perhitungan, maupun penentuan grade.
 */
public class MainApp {

	private static final PengolahNilai pengolahNilai = new PengolahNilai();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		clearScreen();
		tampilkanHeader();

		while (running) {
			tampilkanMenu();
			System.out.print("Pilih menu : ");
			String pilihan = scanner.nextLine().trim();

			switch (pilihan) {
				case "1":
					prosesInputNilai(scanner);
					break;
				case "2":
					clearScreen();
					System.out.println("=============================================");
					System.out.println("   Terima kasih! Program selesai.");
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

	// -------------------------------------------------------------------------
	// Input
	// -------------------------------------------------------------------------

	/**
	 * Mengelola sesi input nilai mahasiswa.
	 * Membaca input, membungkus ke NilaiMahasiswa, minta ulang jika tidak valid.
	 */
	private static void prosesInputNilai(Scanner scanner) {
		clearScreen();
		tampilkanHeader();
		System.out.println("\n  --- INPUT NILAI MAHASISWA ---");

		HasilPengolahan hasil;

		do {
			double tugas = bacaNilai(scanner, "  Nilai Tugas (0-100) : ");
			double uts   = bacaNilai(scanner, "  Nilai UTS   (0-100) : ");
			double uas   = bacaNilai(scanner, "  Nilai UAS   (0-100) : ");

			// Bungkus input ke domain object lalu delegasikan ke PengolahNilai
			NilaiMahasiswa nilaiMahasiswa = new NilaiMahasiswa(tugas, uts, uas);
			hasil = pengolahNilai.proses(nilaiMahasiswa);

			if (!hasil.isValid()) {
				System.out.println("\n  [!] " + hasil.getPesanError());
				System.out.println("  Silakan input ulang.\n");
			}
		} while (!hasil.isValid());

		tampilkanHasil(hasil);
		tekanTombolUntukLanjut(scanner);
	}

	/**
	 * Membaca satu nilai numerik dari pengguna.
	 * Ulangi jika input bukan angka.
	 */
	private static double bacaNilai(Scanner scanner, String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("  [!] Input harus berupa angka. Coba lagi.");
			}
		}
	}

	// -------------------------------------------------------------------------
	// Output
	// -------------------------------------------------------------------------

	private static void tampilkanHasil(HasilPengolahan hasil) {
		System.out.println("\n=============================================");
		System.out.println("  HASIL PENGOLAHAN NILAI");
		System.out.println("=============================================");
		System.out.printf("  Nilai Tugas  (30%%) : %.2f%n", hasil.getNilaiTugas());
		System.out.printf("  Nilai UTS    (30%%) : %.2f%n", hasil.getNilaiUts());
		System.out.printf("  Nilai UAS    (40%%) : %.2f%n", hasil.getNilaiUas());
		System.out.println("---------------------------------------------");
		System.out.printf("  Nilai Akhir        : %.2f%n", hasil.getNilaiAkhir());
		System.out.printf("  Grade              : %s%n",   hasil.getGrade());
		System.out.printf("  Status Kelulusan   : %s%n",   hasil.getStatusKelulusan());
		System.out.println("=============================================");
	}

	private static void tampilkanHeader() {
		System.out.println("=============================================");
		System.out.println("   SISTEM PENGOLAHAN NILAI MAHASISWA");
		System.out.println("   Praktikum PPL - Unit Testing");
		System.out.println("=============================================");
	}

	private static void tampilkanMenu() {
		System.out.println("\n---------------------------------------------");
		System.out.println("  MENU UTAMA");
		System.out.println("---------------------------------------------");
		System.out.println("  1. Input Nilai Mahasiswa");
		System.out.println("  2. Keluar");
		System.out.println("---------------------------------------------");
	}

	private static void tekanTombolUntukLanjut(Scanner scanner) {
		System.out.println("\n---------------------------------------------");
		System.out.print("  Tekan [Enter] untuk kembali ke menu...");
		scanner.nextLine();
		clearScreen();
		tampilkanHeader();
	}

	private static void clearScreen() {
		try {
			String os = System.getProperty("os.name").toLowerCase();
			ProcessBuilder pb = os.contains("windows")
				? new ProcessBuilder("cmd", "/c", "cls")
				: new ProcessBuilder("clear");
			pb.inheritIO().start().waitFor();
		} catch (IOException | InterruptedException e) {
			for (int i = 0; i < 50; i++) System.out.println();
		}
	}
}
