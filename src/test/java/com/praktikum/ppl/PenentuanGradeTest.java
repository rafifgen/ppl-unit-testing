package com.praktikum.ppl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Modul Penentuan Grade")
public class PenentuanGradeTest {

  private PenentuanGrade penentuanGrade = new PenentuanGrade();

  @Test
  @DisplayName("Nilai akhir >= 85 → harus return A")
  void testGradeA() {
    assertEquals("A", penentuanGrade.tentukanGrade(95));
    assertEquals("A", penentuanGrade.tentukanGrade(100));
    assertEquals("A", penentuanGrade.tentukanGrade(85));
  }

  @Test
  @DisplayName("Nilai akhir >= 70 dan < 85 → harus return B")
  void testGradeB() {
    assertEquals("B", penentuanGrade.tentukanGrade(75));
    assertEquals("B", penentuanGrade.tentukanGrade(84));
    assertEquals("B", penentuanGrade.tentukanGrade(70));
  }

  @Test
  @DisplayName("Nilai akhir >= 60 dan < 70 → harus return C")
  void testGradeC() {
    assertEquals("C", penentuanGrade.tentukanGrade(65));
    assertEquals("C", penentuanGrade.tentukanGrade(69));
    assertEquals("C", penentuanGrade.tentukanGrade(60));
  }

  @Test
  @DisplayName("Nilai akhir >= 50 dan < 60 → harus return D")
  void testGradeD() {
    assertEquals("D", penentuanGrade.tentukanGrade(55));
    assertEquals("D", penentuanGrade.tentukanGrade(59));
    assertEquals("D", penentuanGrade.tentukanGrade(50));
  }

  @Test
  @DisplayName("Nilai akhir < 50 → harus return E")
  void testGradeE() {
    assertEquals("E", penentuanGrade.tentukanGrade(25));
    assertEquals("E", penentuanGrade.tentukanGrade(49));
    assertEquals("E", penentuanGrade.tentukanGrade(0));
  }
}
