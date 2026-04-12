package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Modul Hitung Nilai Akhir")
class HitungNilaiAkhirTest {

	private final PengolahNilai pengolahNilai = new PengolahNilai();

	// =====================
	// INVALID INPUT
	// =====================

	@Test
	@DisplayName("Nilai tugas kurang dari 0 → return -1")
	void nilaiTugasKurangDari0() {
		NilaiMahasiswa input = new NilaiMahasiswa(-5, 80, 80);
		double result = pengolahNilai.hitung(input);
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Nilai tugas lebih dari 100 → return -1")
	void nilaiTugasLebihDari100() {
		NilaiMahasiswa input = new NilaiMahasiswa(101, 80, 80);
		double result = pengolahNilai.hitung(input);
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Nilai UTS kurang dari 0 → return -1")
	void nilaiUTSKurangDari0() {
		NilaiMahasiswa input = new NilaiMahasiswa(80, -5, 80);
		double result = pengolahNilai.hitung(input);
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Nilai UTS lebih dari 100 → return -1")
	void nilaiUTSLebihDari100() {
		NilaiMahasiswa input = new NilaiMahasiswa(80, 101, 80);
		double result = pengolahNilai.hitung(input);
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Nilai UAS kurang dari 0 → return -1")
	void nilaiUASKurangDari0() {
		NilaiMahasiswa input = new NilaiMahasiswa(80, 80, -5);
		double result = pengolahNilai.hitung(input);
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Nilai UAS lebih dari 100 → return -1")
	void nilaiUASLebihDari100() {
		NilaiMahasiswa input = new NilaiMahasiswa(80, 80, 101);
		double result = pengolahNilai.hitung(input);
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Semua nilai nol → return -1")
	void semuaNilaiNol() {
		NilaiMahasiswa input = new NilaiMahasiswa(0, 0, 0);
		double result = pengolahNilai.hitung(input);
		assertEquals(-1, result);
	}

	// =====================
	// VALID INPUT
	// =====================

	@Test
	@DisplayName("Semua nilai maksimal (100) → return 100")
	void nilaiMaksimal() {
		NilaiMahasiswa input = new NilaiMahasiswa(100, 100, 100);
		double result = pengolahNilai.hitung(input);
		assertEquals(100, result);
	}

	@Test
	@DisplayName("Semua nilai valid → hasil sesuai perhitungan")
	void nilaiValidNormal() {
		NilaiMahasiswa input = new NilaiMahasiswa(100, 100, 100);
		double result = pengolahNilai.hitung(input);
		assertEquals(100, result);
	}

	@Test
	@DisplayName("Nilai valid → hasil tidak melebihi 100 (capping)")
	void nilaiDicapping() {
		NilaiMahasiswa input = new NilaiMahasiswa(80, 75, 90);
		double result = pengolahNilai.hitung(input);

		assertTrue(result <= 100 && result >= 0);
		assertEquals(82.5, result);
	}
}