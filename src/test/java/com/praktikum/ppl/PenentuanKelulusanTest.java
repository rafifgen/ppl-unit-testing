package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test untuk method tentukanKelulusan() pada PengolahNilai.
 * Tanggung jawab: memastikan penentuan status lulus/tidak lulus berjalan benar.
 *
 * Setiap test case mengikuti pola tiga tahap:
 *   1. Setup   (Arrange) → persiapkan data input
 *   2. Exercise (Act)    → panggil method yang diuji
 *   3. Verify  (Assert)  → periksa hasil yang diharapkan
 */
@DisplayName("Test Modul Penentuan Kelulusan")
class PenentuanKelulusanTest {

	private final PengolahNilai pengolahNilai = new PengolahNilai();

	// =====================
	//  PATH TESTING - TODO
	// =====================
	// Tambahkan test case berdasarkan hasil analisa CFG dan independent path

	@Test
	@DisplayName("Nilai akhir = 60 (boundary) → harus return 'Lulus'")
	void testNilai60() {
		// Setup
		double nilaiAkhir = 60;

		// Exercise
		String result = pengolahNilai.tentukanKelulusan(nilaiAkhir);

		// Verify
		assertEquals("Lulus", result);
	}

	@Test
	@DisplayName("Nilai akhir > 60 → harus return 'Lulus'")
	void testNilaiLebihDari60() {
		// Setup
		double nilaiAkhir = 75;

		// Exercise
		String result = pengolahNilai.tentukanKelulusan(nilaiAkhir);

		// Verify
		assertEquals("Lulus", result);
	}

	@Test
	@DisplayName("Nilai akhir < 60 (boundary) → harus return 'Tidak Lulus'")
	void testNilaiKurangDari60() {
		// Setup
		double nilaiAkhir = 59;

		// Exercise
		String result = pengolahNilai.tentukanKelulusan(nilaiAkhir);

		// Verify
		assertEquals("Tidak Lulus", result);
	}
}
