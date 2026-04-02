# 📚 Pengolahan Nilai Mahasiswa

Aplikasi pengolahan nilai mahasiswa berbasis Java dengan pendekatan **modular**.
Dibuat sebagai _Software Under Test_ (SUT) untuk praktikum **Unit Testing** mata kuliah PPL
menggunakan build tools **Apache Maven** dan framework pengujian **JUnit 5**.

---

## 🗂️ Struktur Project

```
pengolahan-nilai/
├── src/
│   ├── main/java/com/praktikum/ppl/
│   │   ├── MainApp.java              # Aplikasi utama (entry point)
│   │   ├── ValidasiData.java         # Modul validasi input nilai
│   │   ├── HitungNilaiAkhir.java     # Modul perhitungan nilai akhir
│   │   ├── PenentuanGrade.java       # Modul penentuan grade (A/B/C/D/E)
│   │   └── PenentuanKelulusan.java   # Modul penentuan status kelulusan
│   └── test/java/com/praktikum/ppl/
│       └── ValidasiDataTest.java     # Unit test modul validasi
├── target/                           # Hasil build (di-ignore oleh Git)
├── pom.xml                           # Konfigurasi Maven
└── .gitignore
```

---

## ⚙️ Prasyarat

Pastikan tools berikut sudah terinstall di sistem kamu:

| Tools | Versi Minimum | Cek Instalasi |
|-------|--------------|---------------|
| JDK   | 11           | `java -version` |
| Maven | 3.6+         | `mvn -version` |

---

## 🚀 Cara Menjalankan Program

Semua perintah dijalankan melalui **terminal** dari direktori root project.

### 1. Compile Source Code

```bash
mvn compile
```

### 2. Build JAR (Executable)

```bash
mvn package -DskipTests
```

File JAR akan tersimpan di: `target/pengolahan-nilai-1.0-SNAPSHOT.jar`

### 3. Jalankan Aplikasi

```bash
java -jar target/pengolahan-nilai-1.0-SNAPSHOT.jar
```

Contoh tampilan saat berjalan:

```
=============================================
   SISTEM PENGOLAHAN NILAI MAHASISWA
   Praktikum PPL - Unit Testing
=============================================

---------------------------------------------
  MENU UTAMA
---------------------------------------------
  1. Input Nilai Mahasiswa
  2. Keluar
---------------------------------------------
Pilih menu :
```

---

## 🧪 Cara Menjalankan Unit Test

### Jalankan semua test

```bash
mvn test
```

### Jalankan test dengan output detail di console

```bash
mvn test -Dsurefire.useFile=false
```

Contoh output:

```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.praktikum.ppl.ValidasiDataTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO] -------------------------------------------------------
[INFO] BUILD SUCCESS
```

---

## 📊 Generate Test Report (HTML)

```bash
mvn surefire-report:report
```

Buka hasil report di browser:

```
target/site/surefire-report.html
```

---

## 🔄 Perintah Maven Lainnya

| Perintah | Fungsi |
|----------|--------|
| `mvn clean` | Hapus folder `target/` (bersihkan hasil build) |
| `mvn clean compile` | Bersihkan lalu compile ulang |
| `mvn clean package` | Bersihkan lalu build ulang JAR |
| `mvn clean test` | Bersihkan lalu jalankan semua test |
| `mvn dependency:tree` | Tampilkan semua dependency project |

---

## 📐 Aturan Bisnis Modul

### Modul Validasi Data
| Kondisi | Output |
|---------|--------|
| Semua nilai antara 0–100 | `true` (valid) |
| Ada nilai < 0 atau > 100 | `false` (tidak valid) |
| Semua nilai = 0 | `false` (dianggap belum diinput) |

### Modul Perhitungan Nilai Akhir
```
nilai_akhir = (0.3 × tugas) + (0.3 × uts) + (0.4 × uas)
```
Mengembalikan `-1` jika data tidak valid atau hasil > 100.

### Modul Penentuan Grade
| Nilai Akhir | Grade |
|-------------|-------|
| ≥ 85        | A     |
| 70 – 84     | B     |
| 60 – 69     | C     |
| 50 – 59     | D     |
| < 50        | E     |

### Modul Penentuan Kelulusan
| Nilai Akhir | Status     |
|-------------|------------|
| ≥ 60        | Lulus      |
| < 60        | Tidak Lulus|

---

## 👥 Tim Pengembang

Praktikum PPL — Semester 6
Politeknik Negeri Bandung