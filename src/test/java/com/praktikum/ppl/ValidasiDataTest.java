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

	@Test
	@DisplayName("TC1 Menguji nilai invalid dengan semua nilai = 0")
	void testSemuaNilaiNol() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(0, 0, 0);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC2 Menguji nilai invalid dengan nilaiTugas < 0")
	void testNilaiTugasNegatif() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(-1, 75, 90);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC3 Menguji nilai invalid dengan nilai tugas > 100")
	void testNilaiTugasMelebihi100() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(101, 75, 90);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC4 Menguji nilai invalid dengan nilai UTS < 0")
	void testNilaiUtsNegatif() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(75, -1, 90);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC5 Menguji nilai invalid dengan nilai UTS > 100")
	void testNilaiUtsMelebihi100() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(75, 101, 90);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC6 Menguji nilai invalid dengan nilai UAS < 0")
	void testNilaiUasNegatif() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(75, 90, -1);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName("TC7 Menguji nilai invalid dengan nilai UAS > 100")
	void testNilaiUasMelebihi100() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(75, 90, 101);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertFalse(result);
	}

	@Test
	@DisplayName(
		"TC8 Menguji nilai valid dengan semua nilai dalam rentang 0-100"
	)
	void testNilaiValid() {
		// Setup
		NilaiMahasiswa input = new NilaiMahasiswa(75, 90, 80);

		// Exercise
		boolean result = pengolahNilai.validasi(input);

		// Verify
		assertTrue(result);
	}
}
