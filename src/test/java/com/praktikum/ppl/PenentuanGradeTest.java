package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test untuk method tentukanGrade() pada PengolahNilai.
 * Tanggung jawab: memastikan penentuan grade A/B/C/D/E berjalan benar.
 */
@DisplayName("Test Modul Penentuan Grade")
class PenentuanGradeTest {

	private final PengolahNilai pengolahNilai = new PengolahNilai();

	@Test
	@DisplayName("Nilai akhir >= 85 → harus return A")
	void testGradeA() {
		assertEquals("A", pengolahNilai.tentukanGrade(95));
		assertEquals("A", pengolahNilai.tentukanGrade(100));
		assertEquals("A", pengolahNilai.tentukanGrade(85));
	}

	@Test
	@DisplayName("Nilai akhir >= 70 dan < 85 → harus return B")
	void testGradeB() {
		assertEquals("B", pengolahNilai.tentukanGrade(75));
		assertEquals("B", pengolahNilai.tentukanGrade(84));
		assertEquals("B", pengolahNilai.tentukanGrade(70));
	}

	@Test
	@DisplayName("Nilai akhir >= 60 dan < 70 → harus return C")
	void testGradeC() {
		assertEquals("C", pengolahNilai.tentukanGrade(65));
		assertEquals("C", pengolahNilai.tentukanGrade(69));
		assertEquals("C", pengolahNilai.tentukanGrade(60));
	}

	@Test
	@DisplayName("Nilai akhir >= 50 dan < 60 → harus return D")
	void testGradeD() {
		assertEquals("D", pengolahNilai.tentukanGrade(55));
		assertEquals("D", pengolahNilai.tentukanGrade(59));
		assertEquals("D", pengolahNilai.tentukanGrade(50));
	}

	@Test
	@DisplayName("Nilai akhir < 50 → harus return E")
	void testGradeE() {
		assertEquals("E", pengolahNilai.tentukanGrade(25));
		assertEquals("E", pengolahNilai.tentukanGrade(49));
		assertEquals("E", pengolahNilai.tentukanGrade(0));
	}
}
