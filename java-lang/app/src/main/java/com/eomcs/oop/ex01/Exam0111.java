package com.eomcs.oop.ex01;


public class Exam0111 {
  public static void main(String[] args) {

    String name;
    int kor;
    int eng;
    int math;

    name = "홍길동";
    kor = 100;
    eng = 90;
    math = 85;


    printScore(name, kor, eng, math);
  }

  static void printScore(String name, int kor, int eng, int math) {
    int sum = kor + eng + math;
    float aver = sum / 3f;
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);
  }
}