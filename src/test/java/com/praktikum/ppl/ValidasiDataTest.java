package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test untuk method validasi() pada PengolahNilai.
 * Tanggung jawab: memastikan validasi input NilaiMahasiswa berjalan benar.
 */
@DisplayName("Test Modul Validasi Data")
class ValidasiDataTest {

	private final PengolahNilai pengolahNilai = new PengolahNilai();

	// =====================
	//  PATH TESTING - TODO
	// =====================
	// Tambahkan test case berdasarkan hasil analisa CFG dan independent path

	@Test
	@DisplayName("TC1 Semua nilai = 0 → harus return false (belum input)")
	void testSemuaNilaiNol() {
		assertFalse(pengolahNilai.validasi(new NilaiMahasiswa(0, 0, 0)));
	}

	@Test
	@DisplayName("TC2 Nilai tugas < 0")
	void testNilaiTugasNegatif() {
		assertFalse(pengolahNilai.validasi(new NilaiMahasiswa(-1, 75, 90)));
	}

	@Test
	@DisplayName("TC3 Nilai tugas > 100")
	void testNilaiTugasMelebihi100() {
		assertFalse(pengolahNilai.validasi(new NilaiMahasiswa(101, 75, 90)));
	}

	@Test
	@DisplayName("TC4 Nilai UTS < 0")
	void testNilaiUtsNegatif() {
		assertFalse(pengolahNilai.validasi(new NilaiMahasiswa(75, -1, 90)));
	}

	@Test
	@DisplayName("TC5 Nilai UTS > 100")
	void testNilaiUtsMelebihi100() {
		assertFalse(pengolahNilai.validasi(new NilaiMahasiswa(75, 101, 90)));
	}

	@Test
	@DisplayName("TC6 Nilai UAS < 0")
	void testNilaiUasNegatif() {
		assertFalse(pengolahNilai.validasi(new NilaiMahasiswa(75, 90, -1)));
	}

	@Test
	@DisplayName("TC7 Nilai UAS > 100")
	void testNilaiUasMelebihi100() {
		assertFalse(pengolahNilai.validasi(new NilaiMahasiswa(75, 90, 101)));
	}

	@Test
	@DisplayName("TC8 Semua nilai dalam rentang 0-100")
	void testNilaiValid() {
		assertTrue(pengolahNilai.validasi(new NilaiMahasiswa(75, 90, 80)));
	}
}
