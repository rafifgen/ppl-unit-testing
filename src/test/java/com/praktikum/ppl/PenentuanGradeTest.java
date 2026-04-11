package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test untuk method tentukanGrade() pada PengolahNilai.
 * Tanggung jawab: memastikan penentuan grade A/B/C/D/E berjalan benar.
 *
 * Setiap test case mengikuti pola tiga tahap:
 * 1. Setup (Arrange) → persiapkan data input
 * 2. Exercise (Act) → panggil method yang diuji
 * 3. Verify (Assert) → periksa hasil yang diharapkan
 */
@DisplayName("Test Modul Penentuan Grade")
class PenentuanGradeTest {

	private final PengolahNilai pengolahNilai = new PengolahNilai();

	@Test
	@DisplayName("Nilai akhir 95 → harus return A")
	void testGradeATengah() {
		// Setup
		double nilai = 95;

		// Exercise
		String result = pengolahNilai.tentukanGrade(nilai);

		// Verify
		assertEquals("A", result);
	}

	@Test
	@DisplayName("Nilai akhir 85 (batas bawah) → harus return A")
	void testGradeABatasBawah() {
		double nilai = 85;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("A", result);
	}

	@Test
	@DisplayName("Nilai akhir 100 (maksimal) → harus return A")
	void testGradeABatasAtas() {
		double nilai = 100;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("A", result);
	}

	@Test
	@DisplayName("Nilai akhir 75 → harus return B")
	void testGradeBTengah() {
		double nilai = 75;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("B", result);
	}

	@Test
	@DisplayName("Nilai akhir 84 (batas atas) → harus return B")
	void testGradeBBatasAtas() {
		double nilai = 84;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("B", result);
	}

	@Test
	@DisplayName("Nilai akhir 70 (batas bawah) → harus return B")
	void testGradeBBatasBawah() {
		double nilai = 70;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("B", result);
	}

	@Test
	@DisplayName("Nilai akhir 65 → harus return C")
	void testGradeCTengah() {
		double nilai = 65;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("C", result);
	}

	@Test
	@DisplayName("Nilai akhir 69 (batas atas) → harus return C")
	void testGradeCBatasAtas() {
		double nilai = 69;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("C", result);
	}

	@Test
	@DisplayName("Nilai akhir 60 (batas bawah) → harus return C")
	void testGradeCBatasBawah() {
		double nilai = 60;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("C", result);
	}

	@Test
	@DisplayName("Nilai akhir 55 → harus return D")
	void testGradeDTengah() {
		double nilai = 55;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("D", result);
	}

	@Test
	@DisplayName("Nilai akhir 59 (batas atas) → harus return D")
	void testGradeDBatasAtas() {
		double nilai = 59;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("D", result);
	}

	@Test
	@DisplayName("Nilai akhir 50 (batas bawah) → harus return D")
	void testGradeDBatasBawah() {
		double nilai = 50;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("D", result);
	}

	@Test
	@DisplayName("Nilai akhir 25 → harus return E")
	void testGradeETengah() {
		double nilai = 25;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("E", result);
	}

	@Test
	@DisplayName("Nilai akhir 49 (batas atas) → harus return E")
	void testGradeEBatasAtas() {
		double nilai = 49;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("E", result);
	}

	@Test
	@DisplayName("Nilai akhir 0 (minimum) → harus return E")
	void testGradeEBatasBawah() {
		double nilai = 0;
		String result = pengolahNilai.tentukanGrade(nilai);
		assertEquals("E", result);
	}
}
