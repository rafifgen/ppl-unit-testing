package com.praktikum.ppl;

/**
 * Result Object - Hasil Pengolahan Nilai Mahasiswa
 *
 * Menyimpan seluruh hasil pengolahan yang dikembalikan oleh {@link PengolahNilai}.
 * Bersifat immutable — dibuat sekali dan tidak bisa diubah.
 *
 * Dua kemungkinan state:
 * 1. Valid   : pengolahan berhasil, nilaiAkhir/grade/statusKelulusan terisi
 * 2. Invalid : pengolahan gagal, pesanError berisi penjelasannya
 */
public class HasilPengolahan {

	private final NilaiMahasiswa nilaiMahasiswa;
	private final double nilaiAkhir;
	private final String grade;
	private final String statusKelulusan;
	private final boolean valid;
	private final String pesanError;

	/**
	 * Konstruktor untuk hasil yang berhasil diproses (valid).
	 *
	 * @param nilaiMahasiswa  data nilai input mahasiswa
	 * @param nilaiAkhir      nilai akhir hasil perhitungan
	 * @param grade           grade yang diperoleh (A/B/C/D/E)
	 * @param statusKelulusan "Lulus" atau "Tidak Lulus"
	 */
	public HasilPengolahan(
		NilaiMahasiswa nilaiMahasiswa,
		double nilaiAkhir,
		String grade,
		String statusKelulusan
	) {
		this.nilaiMahasiswa  = nilaiMahasiswa;
		this.nilaiAkhir      = nilaiAkhir;
		this.grade           = grade;
		this.statusKelulusan = statusKelulusan;
		this.valid           = true;
		this.pesanError      = null;
	}

	/**
	 * Konstruktor untuk hasil yang gagal diproses (tidak valid).
	 *
	 * @param nilaiMahasiswa data nilai input yang gagal diproses
	 * @param pesanError     pesan yang menjelaskan penyebab kegagalan
	 */
	public HasilPengolahan(NilaiMahasiswa nilaiMahasiswa, String pesanError) {
		this.nilaiMahasiswa  = nilaiMahasiswa;
		this.nilaiAkhir      = -1;
		this.grade           = null;
		this.statusKelulusan = null;
		this.valid           = false;
		this.pesanError      = pesanError;
	}

	// -------------------------------------------------------------------------
	// Getters
	// -------------------------------------------------------------------------

	public NilaiMahasiswa getNilaiMahasiswa() { return nilaiMahasiswa; }

	/** Shortcut getter — delegate ke NilaiMahasiswa */
	public double getNilaiTugas()       { return nilaiMahasiswa.getNilaiTugas(); }
	public double getNilaiUts()         { return nilaiMahasiswa.getNilaiUts(); }
	public double getNilaiUas()         { return nilaiMahasiswa.getNilaiUas(); }

	public double getNilaiAkhir()       { return nilaiAkhir; }
	public String getGrade()            { return grade; }
	public String getStatusKelulusan()  { return statusKelulusan; }
	public boolean isValid()            { return valid; }
	public String getPesanError()       { return pesanError; }
}
