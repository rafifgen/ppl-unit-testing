package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Modul Validasi Data")
class ValidasiDataTest {

	private final ValidasiData validasiData = new ValidasiData();

	// =====================
	//  PATH TESTING - TODO
	// =====================
	// Tambahkan test case berdasarkan hasil analisa CFG dan independent path

	@Test
	@DisplayName("TC1 Semua nilai = 0 → harus return false (belum input)")
	void testSemuaNilaiNol() {
		assertFalse(validasiData.validasi(0, 0, 0));
	}

	@Test
	@DisplayName("TC2 Nilai tugas < 0")
	void testNilaiTugasNol() {
		assertFalse(validasiData.validasi(-1, 75, 90));
	}

	@Test
	@DisplayName("TC3 Nilai tugas > 100")
	void testNilaiTugas100() {
		assertFalse(validasiData.validasi(101, 75, 90));
	}

	@Test
	@DisplayName("TC4 Nilai UTS < 0")
	void testNilaiUTSNol() {
		assertFalse(validasiData.validasi(75, -1, 90));
	}

	@Test
	@DisplayName("TC 5Nilai UTS > 100")
	void testNilaiUTS100() {
		assertFalse(validasiData.validasi(75, -1, 90));
	}

	@Test
	@DisplayName("TC6 Nilai UAS < 0")
	void testNilaiUASNol() {
		assertFalse(validasiData.validasi(75, 90, -1));
	}

	@Test
	@DisplayName("TC7 Nilai UAS > 100")
	void testNilaiUAS100() {
		assertFalse(validasiData.validasi(75, 90, 101));
	}

	@Test
	@DisplayName("TC8 Semua nilai dalam rentang 0-100")
	void testNilaiValid() {
		assertTrue(validasiData.validasi(75, 90, 80));
	}
}
