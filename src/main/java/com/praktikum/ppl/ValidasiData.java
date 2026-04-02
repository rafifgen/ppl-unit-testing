package com.praktikum.ppl;

/**
 * Modul Validasi Data
 * Memvalidasi input nilai tugas, UTS, dan UAS mahasiswa.
 */
public class ValidasiData {

    /**
     * Memvalidasi nilai mahasiswa.
     *
     * @param nilaiTugas nilai tugas (0-100)
     * @param nilaiUts   nilai UTS (0-100)
     * @param nilaiUas   nilai UAS (0-100)
     * @return true jika valid, false jika tidak valid
     */
    public boolean validasi(double nilaiTugas, double nilaiUts, double nilaiUas) {
        // Aturan 3: Jika semua nilai = 0 → tidak valid (belum input)
        if (nilaiTugas == 0 && nilaiUts == 0 && nilaiUas == 0) {
            return false;
        }
        // Aturan 2: Jika ada nilai < 0 atau > 100 → tidak valid
        if (nilaiTugas < 0 || nilaiTugas > 100 ||
            nilaiUts < 0   || nilaiUts > 100   ||
            nilaiUas < 0   || nilaiUas > 100) {
            return false;
        }
        // Aturan 1: Semua nilai antara 0–100 → valid
        return true;
    }
}
