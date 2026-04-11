package com.praktikum.ppl;

/**
 * Value Object - Data Nilai Mahasiswa
 *
 * Merepresentasikan tiga komponen nilai mahasiswa sebagai satu kesatuan objek.
 * Bersifat immutable: setelah dibuat, nilainya tidak bisa diubah.
 *
 * Objek ini dikirimkan antar modul sehingga tidak ada 3 parameter double
 * yang mengambang secara terpisah.
 */
public class NilaiMahasiswa {

	private final double nilaiTugas;
	private final double nilaiUts;
	private final double nilaiUas;

	/**
	 * Membuat objek NilaiMahasiswa dengan tiga komponen nilai.
	 *
	 * @param nilaiTugas nilai tugas (bobot 30%)
	 * @param nilaiUts   nilai UTS (bobot 30%)
	 * @param nilaiUas   nilai UAS (bobot 40%)
	 */
	public NilaiMahasiswa(double nilaiTugas, double nilaiUts, double nilaiUas) {
		this.nilaiTugas = nilaiTugas;
		this.nilaiUts   = nilaiUts;
		this.nilaiUas   = nilaiUas;
	}

	public double getNilaiTugas() { return nilaiTugas; }
	public double getNilaiUts()   { return nilaiUts; }
	public double getNilaiUas()   { return nilaiUas; }

	@Override
	public String toString() {
		return String.format(
			"NilaiMahasiswa{tugas=%.2f, uts=%.2f, uas=%.2f}",
			nilaiTugas, nilaiUts, nilaiUas
		);
	}
}
