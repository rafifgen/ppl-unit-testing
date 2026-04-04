package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Modul Penentuan Kelulusan")
class PenentuanKelulusanTest {

	private final PenentuanKelulusan penentuanKelulusan = new PenentuanKelulusan();

	// =====================
	//  PATH TESTING - TODO
	// =====================
	// Tambahkan test case berdasarkan hasil analisa CFG dan independent path

	@Test
	@DisplayName("Nilai akhir = 60 (boundary) → harus return 'Lulus'")
	void testNilai60() {
		String result = penentuanKelulusan.tentukanKelulusan(60);
		assertEquals("Lulus", result);
	}

	@Test
	@DisplayName("Nilai akhir > 60 → harus return 'Lulus'")
	void testNilaiLebihDari60() {
		String result = penentuanKelulusan.tentukanKelulusan(75);
		assertEquals("Lulus", result);
	}

	@Test
	@DisplayName("Nilai akhir < 60 (boundary) → harus return 'Tidak Lulus'")
	void testNilaiKurangDari60() {
		String result = penentuanKelulusan.tentukanKelulusan(59);
		assertEquals("Tidak Lulus", result);
	}

}
