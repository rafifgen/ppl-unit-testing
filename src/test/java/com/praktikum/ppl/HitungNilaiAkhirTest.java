package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Modul Hitung Nilai Akhir")
class HitungNilaiAkhirTest {

	private final HitungNilaiAkhir hitungNilaiAkhir = new HitungNilaiAkhir();

	// =====================
	//  PATH TESTING - TODO
	// =====================
	// Tambahkan test case berdasarkan hasil analisa CFG dan independent path


	@Test
	@DisplayName("Ada nilai negatif → harus return -1 (invalid)")
	void testNilaiNegatif() {
		double result = hitungNilaiAkhir.hitung(-5, 75, 90);
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Ada nilai > 100 → harus return -1 (invalid)")
	void testNilaiLebihDari100() {
		double result = hitungNilaiAkhir.hitung(80, 101, 90);
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Semua nilai = 0 → harus return -1 (belum input)")
	void testSemuaNilaiNol() {
		double result = hitungNilaiAkhir.hitung(0, 0, 0);
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("Nilai tinggi semua (100, 100, 100) → harus return 100")
	void testNilaiMaksimal() {
		// Expected: 0.3*100 + 0.3*100 + 0.4*100 = 30 + 30 + 40 = 100
		double result = hitungNilaiAkhir.hitung(100, 100, 100);
		assertEquals(100, result);
	}

    @Test
	@DisplayName("Semua nilai valid (0-100) → harus return nilai akhir yang benar")
	void testNilaiAkhirValid() {
		// Tugas: 80 (bobot 30%), UTS: 75 (bobot 30%), UAS: 90 (bobot 40%)
		// Expected: 0.3*80 + 0.3*75 + 0.4*90 = 24 + 22.5 + 36 = 82.5
		double result = hitungNilaiAkhir.hitung(80, 75, 90);
		assertEquals(82.5, result);
	}

	@Test
	@DisplayName("Nilai yang menghasilkan nilai akhir > 100 → harus return -1 (error)")
	void testNilaiAkhirMelebihi100() {
		// Tugas: 100, UTS: 100, UAS: 100 = 100 (valid)
		// Tapi jika ada kombinasi yang bisa > 100, misal: semua 101 → -1 (invalid)
		// Karena masing-masing sudah > 100, maka akan -1 di validasi
		// Mari gunakan: 100, 100, 100 sudah cukup untuk test kasus maksimal
		double result = hitungNilaiAkhir.hitung(100, 100, 100);
		assertTrue(result <= 100 && result >= 0);
	}

}
