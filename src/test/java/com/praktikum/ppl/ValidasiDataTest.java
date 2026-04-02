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
	@DisplayName("Semua nilai valid (0-100) → harus return true")
	void testNilaiValid() {
		assertTrue(validasiData.validasi(80, 75, 90));
	}

	@Test
	@DisplayName("Ada nilai < 0 → harus return false")
	void testNilaiNegatif() {
		assertFalse(validasiData.validasi(-1, 75, 90));
	}

	@Test
	@DisplayName("Ada nilai > 100 → harus return false")
	void testNilaiLebihDari100() {
		assertFalse(validasiData.validasi(80, 101, 90));
	}

	@Test
	@DisplayName("Semua nilai = 0 → harus return false (belum input)")
	void testSemuaNilaiNol() {
		assertFalse(validasiData.validasi(0, 0, 0));
	}
}
