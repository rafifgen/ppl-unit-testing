package com.praktikum.ppl;

/**
 * Modul Penentuan Kelulusan
 * Menentukan status kelulusan mahasiswa berdasarkan nilai akhir.
 */
public class PenentuanKelulusan {

    /**
     * Menentukan status kelulusan mahasiswa.
     *
     * @param nilaiAkhir nilai akhir mahasiswa
     * @return "Lulus" jika nilai ≥ 60, "Tidak Lulus" jika < 60
     */
    public String tentukanKelulusan(double nilaiAkhir) {
        if (nilaiAkhir >= 60) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }
}
