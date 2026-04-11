package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test untuk method validasi() pada PengolahNilai.
 * Tanggung jawab: memastikan validasi input NilaiMahasiswa berjalan benar.
 *
 * Setiap test case mengikuti pola tiga tahap:
 *   1. Setup   (Arrange) → persiapkan data input
 *   2. Exercise (Act)    → panggil method yang diuji
 *   3. Verify  (Assert)  → periksa hasil yang diharapkan
 */
@DisplayName("Test Modul Validasi Data")
class ValidasiDataTest {

	private final PengolahNilai pengolahNilai = new PengolahNilai();

	// =====================
	//  PATH TESTING - TODO
	// =====================
	// Tambahkan test case berdasarkan hasil analisa CFG dan independent path

	@Test
	@DisplayName("TC1 Semua nilai = 0 → harus return false (belum input)")
	void testSemuaNilaiNol() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(0, 0, 0);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC2 Nilai tugas < 0 → harus return false")
	void testNilaiTugasNegatif() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(-1, 75, 90);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC3 Nilai tugas > 100 → harus return false")
	void testNilaiTugasMelebihi100() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(101, 75, 90);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC4 Nilai UTS < 0 → harus return false")
	void testNilaiUtsNegatif() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(75, -1, 90);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC5 Nilai UTS > 100 → harus return false")
	void testNilaiUtsMelebihi100() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(75, 101, 90);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC6 Nilai UAS < 0 → harus return false")
	void testNilaiUasNegatif() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(75, 90, -1);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC7 Nilai UAS > 100 → harus return false")
	void testNilaiUasMelebihi100() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(75, 90, 101);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC8 Semua nilai dalam rentang 0-100 → harus return true")
	void testNilaiValid() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(75, 90, 80);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertTrue(result);
	}
}
