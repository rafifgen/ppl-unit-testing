package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test untuk method tentukanGrade() pada PengolahNilai.
 * Tanggung jawab: memastikan penentuan grade A/B/C/D/E berjalan benar.
 *
 * Setiap test case mengikuti pola tiga tahap:
 *   1. Setup   (Arrange) → persiapkan data input
 *   2. Exercise (Act)    → panggil method yang diuji
 *   3. Verify  (Assert)  → periksa hasil yang diharapkan
 */
@DisplayName("Test Modul Penentuan Grade")
class PenentuanGradeTest {

	private final PengolahNilai pengolahNilai = new PengolahNilai();

	@Test
	@DisplayName("Nilai akhir >= 85 → harus return A")
	void testGradeA() {
		// Setup
		double nilaiTengah    = 95;
		double nilaiBatas     = 85;
		double nilaiMaksimal  = 100;

		// Exercise
		String resultTengah   = pengolahNilai.tentukanGrade(nilaiTengah);
		String resultBatas    = pengolahNilai.tentukanGrade(nilaiBatas);
		String resultMaksimal = pengolahNilai.tentukanGrade(nilaiMaksimal);

		// Verify
		assertEquals("A", resultTengah);
		assertEquals("A", resultBatas);
		assertEquals("A", resultMaksimal);
	}

	@Test
	@DisplayName("Nilai akhir >= 70 dan < 85 → harus return B")
	void testGradeB() {
		// Setup
		double nilaiTengah = 75;
		double nilaiAtas   = 84;
		double nilaiBatas  = 70;

		// Exercise
		String resultTengah = pengolahNilai.tentukanGrade(nilaiTengah);
		String resultAtas   = pengolahNilai.tentukanGrade(nilaiAtas);
		String resultBatas  = pengolahNilai.tentukanGrade(nilaiBatas);

		// Verify
		assertEquals("B", resultTengah);
		assertEquals("B", resultAtas);
		assertEquals("B", resultBatas);
	}

	@Test
	@DisplayName("Nilai akhir >= 60 dan < 70 → harus return C")
	void testGradeC() {
		// Setup
		double nilaiTengah = 65;
		double nilaiAtas   = 69;
		double nilaiBatas  = 60;

		// Exercise
		String resultTengah = pengolahNilai.tentukanGrade(nilaiTengah);
		String resultAtas   = pengolahNilai.tentukanGrade(nilaiAtas);
		String resultBatas  = pengolahNilai.tentukanGrade(nilaiBatas);

		// Verify
		assertEquals("C", resultTengah);
		assertEquals("C", resultAtas);
		assertEquals("C", resultBatas);
	}

	@Test
	@DisplayName("Nilai akhir >= 50 dan < 60 → harus return D")
	void testGradeD() {
		// Setup
		double nilaiTengah = 55;
		double nilaiAtas   = 59;
		double nilaiBatas  = 50;

		// Exercise
		String resultTengah = pengolahNilai.tentukanGrade(nilaiTengah);
		String resultAtas   = pengolahNilai.tentukanGrade(nilaiAtas);
		String resultBatas  = pengolahNilai.tentukanGrade(nilaiBatas);

		// Verify
		assertEquals("D", resultTengah);
		assertEquals("D", resultAtas);
		assertEquals("D", resultBatas);
	}

	@Test
	@DisplayName("Nilai akhir < 50 → harus return E")
	void testGradeE() {
		// Setup
		double nilaiTengah = 25;
		double nilaiBatas  = 49;
		double nilaiNol    = 0;

		// Exercise
		String resultTengah = pengolahNilai.tentukanGrade(nilaiTengah);
		String resultBatas  = pengolahNilai.tentukanGrade(nilaiBatas);
		String resultNol    = pengolahNilai.tentukanGrade(nilaiNol);

		// Verify
		assertEquals("E", resultTengah);
		assertEquals("E", resultBatas);
		assertEquals("E", resultNol);
	}
}
