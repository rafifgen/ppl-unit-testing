package com.praktikum.ppl;

/**
 * Modul Pengolah Nilai Mahasiswa
 *
 * Kelas tunggal yang mengintegrasikan seluruh proses pengolahan nilai:
 *
 *   1. validasi()         → memvalidasi input NilaiMahasiswa
 *   2. hitung()           → menghitung nilai akhir berdasarkan bobot
 *   3. tentukanGrade()    → menentukan grade (A/B/C/D/E)
 *   4. tentukanKelulusan()→ menentukan status lulus / tidak lulus
 *   5. proses()           → mengorkestrasikan semua langkah di atas
 *
 * MainApp hanya berinteraksi dengan kelas ini melalui method proses().
 */
public class PengolahNilai {

	// =========================================================================
	// Konstanta Bobot Penilaian
	// =========================================================================

	private static final double BOBOT_TUGAS = 0.3;
	private static final double BOBOT_UTS   = 0.3;
	private static final double BOBOT_UAS   = 0.4;

	// =========================================================================
	// 1. Modul Validasi Data
	// =========================================================================

	/**
	 * Memvalidasi data nilai mahasiswa berdasarkan tiga aturan:
	 * 1. Semua nilai antara 0–100         → valid
	 * 2. Ada nilai < 0 atau > 100          → tidak valid
	 * 3. Semua nilai = 0 (belum diisi)     → tidak valid
	 *
	 * @param nilaiMahasiswa objek yang berisi nilai tugas, UTS, dan UAS
	 * @return true jika valid, false jika tidak valid
	 */
	public boolean validasi(NilaiMahasiswa nilaiMahasiswa) {
		double tugas = nilaiMahasiswa.getNilaiTugas();
		double uts   = nilaiMahasiswa.getNilaiUts();
		double uas   = nilaiMahasiswa.getNilaiUas();

		// Aturan 3: semua nol → belum diisi
		if (tugas == 0 && uts == 0 && uas == 0) {
			return false;
		}
		// Aturan 2: ada yang di luar rentang 0-100
		if (tugas < 0 || tugas > 100 ||
			uts   < 0 || uts   > 100 ||
			uas   < 0 || uas   > 100) {
			return false;
		}
		// Aturan 1: semua dalam rentang 0-100 → valid
		return true;
	}

	// =========================================================================
	// 2. Modul Perhitungan Nilai Akhir
	// =========================================================================

	/**
	 * Menghitung nilai akhir mahasiswa.
	 *
	 * Aturan:
	 * 1. nilaiAkhir = (0.3 × tugas) + (0.3 × uts) + (0.4 × uas)
	 * 2. Jika nilai tidak valid → return -1
	 * 3. Jika nilai akhir > 100 → return -1 (error)
	 *
	 * @param nilaiMahasiswa objek nilai mahasiswa
	 * @return nilai akhir, atau -1 jika tidak valid
	 */
	public double hitung(NilaiMahasiswa nilaiMahasiswa) {
		if (!validasi(nilaiMahasiswa)) {
			return -1;
		}

		double nilaiAkhir =
			(BOBOT_TUGAS * nilaiMahasiswa.getNilaiTugas()) +
			(BOBOT_UTS   * nilaiMahasiswa.getNilaiUts())   +
			(BOBOT_UAS   * nilaiMahasiswa.getNilaiUas());

		if (nilaiAkhir > 100) {
			return -1;
		}

		return nilaiAkhir;
	}

	// =========================================================================
	// 3. Modul Penentuan Grade
	// =========================================================================

	/**
	 * Menentukan grade berdasarkan nilai akhir.
	 *
	 * Aturan:
	 * - nilai ≥ 85      → A
	 * - 70 ≤ nilai < 85 → B
	 * - 60 ≤ nilai < 70 → C
	 * - 50 ≤ nilai < 60 → D
	 * - nilai < 50      → E
	 *
	 * @param nilaiAkhir nilai akhir mahasiswa
	 * @return grade: A, B, C, D, atau E
	 */
	public String tentukanGrade(double nilaiAkhir) {
		if (nilaiAkhir >= 85) {
			return "A";
		} else if (nilaiAkhir >= 70) {
			return "B";
		} else if (nilaiAkhir >= 60) {
			return "C";
		} else if (nilaiAkhir >= 50) {
			return "D";
		} else {
			return "E";
		}
	}

	// =========================================================================
	// 4. Modul Penentuan Kelulusan
	// =========================================================================

	/**
	 * Menentukan status kelulusan berdasarkan nilai akhir.
	 *
	 * Aturan:
	 * - nilai ≥ 60 → "Lulus"
	 * - nilai < 60 → "Tidak Lulus"
	 *
	 * @param nilaiAkhir nilai akhir mahasiswa
	 * @return "Lulus" atau "Tidak Lulus"
	 */
	public String tentukanKelulusan(double nilaiAkhir) {
		if (nilaiAkhir >= 60) {
			return "Lulus";
		} else {
			return "Tidak Lulus";
		}
	}

	// =========================================================================
	// 5. Proses Utama — Orchestrator
	// =========================================================================

	/**
	 * Memproses nilai mahasiswa secara lengkap.
	 *
	 * Alur:
	 * 1. validasi()          → cek keabsahan input
	 * 2. hitung()            → hitung nilai akhir
	 * 3. tentukanGrade()     → tentukan grade
	 * 4. tentukanKelulusan() → tentukan status kelulusan
	 *
	 * @param nilaiMahasiswa objek nilai mahasiswa yang akan diproses
	 * @return objek HasilPengolahan berisi semua hasil
	 */
	public HasilPengolahan proses(NilaiMahasiswa nilaiMahasiswa) {
		// Langkah 1: Validasi
		if (!validasi(nilaiMahasiswa)) {
			return new HasilPengolahan(
				nilaiMahasiswa,
				"Data tidak valid! Pastikan semua nilai berada di rentang 0–100 "
					+ "dan tidak semuanya 0."
			);
		}

		// Langkah 2: Hitung nilai akhir
		double nilaiAkhir = hitung(nilaiMahasiswa);
		if (nilaiAkhir == -1) {
			return new HasilPengolahan(
				nilaiMahasiswa,
				"Terjadi kesalahan saat menghitung nilai akhir."
			);
		}

		// Langkah 3: Tentukan grade
		String grade = tentukanGrade(nilaiAkhir);

		// Langkah 4: Tentukan status kelulusan
		String statusKelulusan = tentukanKelulusan(nilaiAkhir);

		return new HasilPengolahan(nilaiMahasiswa, nilaiAkhir, grade, statusKelulusan);
	}
}
