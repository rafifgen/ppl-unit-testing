package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test untuk method hitung() pada PengolahNilai.
 * Tanggung jawab: memastikan perhitungan nilai akhir berjalan benar.
 *
 * Setiap test case mengikuti pola tiga tahap:
 *   1. Setup   (Arrange) → persiapkan data input
 *   2. Exercise (Act)    → panggil method yang diuji
 *   3. Verify  (Assert)  → periksa hasil yang diharapkan
 */
@DisplayName("Test Modul Hitung Nilai Akhir")
class HitungNilaiAkhirTest {

	private final PengolahNilai pengolahNilai = new PengolahNilai();

	// =====================
	//  PATH TESTING - TODO
	// =====================
	// Tambahkan test case berdasarkan hasil analisa CFG dan independent path

	@Test
	@DisplayName("Ada nilai negatif → harus return -1 (invalid)")
	void testNilaiNegatif() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(-5, 75, 90);

		// Exercise
		double result = pengolahNilai.hitung(input);

		// Verify
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Ada nilai > 100 → harus return -1 (invalid)")
	void testNilaiLebihDari100() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(80, 101, 90);

		// Exercise
		double result = pengolahNilai.hitung(input);

		// Verify
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Semua nilai = 0 → harus return -1 (belum input)")
	void testSemuaNilaiNol() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(0, 0, 0);

		// Exercise
		double result = pengolahNilai.hitung(input);

		// Verify
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Nilai tinggi semua (100, 100, 100) → harus return 100")
	void testNilaiMaksimal() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(100, 100, 100);

		// Exercise
		double result = pengolahNilai.hitung(input);

		// Verify
		// Expected: 0.3*100 + 0.3*100 + 0.4*100 = 100
		assertEquals(100, result);
	}

	@Test
	@DisplayName("Semua nilai valid → harus return nilai akhir yang benar")
	void testNilaiAkhirValid() {
		// Setup
		// Tugas: 80 (30%), UTS: 75 (30%), UAS: 90 (40%)
		NilaiMahasiswa input = new NilaiMahasiswa(80, 75, 90);

		// Exercise
		double result = pengolahNilai.hitung(input);

		// Verify
		// Expected: 0.3*80 + 0.3*75 + 0.4*90 = 24 + 22.5 + 36 = 82.5
		assertEquals(82.5, result);
	}

	@Test
	@DisplayName("Nilai maksimal (100, 100, 100) → hasil tidak melebihi 100")
	void testNilaiAkhirTidakMelebihi100() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(100, 100, 100);

		// Exercise
		double result = pengolahNilai.hitung(input);

		// Verify
		assertTrue(result <= 100 && result >= 0);
	}
}
