package com.praktikum.ppl;

/**
 * Modul Perhitungan Nilai Akhir
 * Menghitung nilai akhir berdasarkan bobot tugas, UTS, dan UAS.
 */
public class HitungNilaiAkhir {

	private final ValidasiData validasiData = new ValidasiData();

	/**
	 * Menghitung nilai akhir mahasiswa.
	 *
	 * @param nilaiTugas nilai tugas (bobot 30%)
	 * @param nilaiUts   nilai UTS (bobot 30%)
	 * @param nilaiUas   nilai UAS (bobot 40%)
	 * @return nilai akhir, atau -1 jika data tidak valid
	 */
	public double hitung(double nilaiTugas, double nilaiUts, double nilaiUas) {
		// Jika nilai tidak valid → return error (-1)
		if (!validasiData.validasi(nilaiTugas, nilaiUts, nilaiUas)) {
			return -1;
		}

		double nilaiAkhir =
			(0.3 * nilaiTugas) + (0.3 * nilaiUts) + (0.4 * nilaiUas);

		// Jika nilai akhir > 100 → dianggap error
		if (nilaiAkhir > 100) {
			return -1;
		}

		return nilaiAkhir;
	}
}
