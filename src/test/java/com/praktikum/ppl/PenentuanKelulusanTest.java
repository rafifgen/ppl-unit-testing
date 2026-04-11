package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test untuk method tentukanKelulusan() pada PengolahNilai.
 * Tanggung jawab: memastikan penentuan status lulus/tidak lulus berjalan benar.
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
		assertEquals("Lulus", pengolahNilai.tentukanKelulusan(60));
	}

	@Test
	@DisplayName("Nilai akhir > 60 → harus return 'Lulus'")
	void testNilaiLebihDari60() {
		assertEquals("Lulus", pengolahNilai.tentukanKelulusan(75));
	}

	@Test
	@DisplayName("Nilai akhir < 60 (boundary) → harus return 'Tidak Lulus'")
	void testNilaiKurangDari60() {
		assertEquals("Tidak Lulus", pengolahNilai.tentukanKelulusan(59));
	}
}
