package com.praktikum.ppl;

/**
 * Modul Penentuan Grade
 * Menentukan grade mahasiswa berdasarkan nilai akhir.
 */
public class PenentuanGrade {

	/**
	 * Menentukan grade mahasiswa.
	 *
	 * @param nilaiAkhir nilai akhir mahasiswa
	 * @return grade: A, B, C, D, atau E
	 */
	public String tentukanGrade(double nilaiAkhir) {
		if (nilaiAkhir >= 85) {
			return "A";
		} else if (nilaiAkhir >= 70) {
			return "B";
		} else if (nilaiAkhir >= 60) {
			return "C";
		} else if (nilaiAkhir >= 50) {
			return "D";
		} else {
			return "E";
		}
	}
}
