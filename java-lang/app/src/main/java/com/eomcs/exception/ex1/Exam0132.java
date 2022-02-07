package com.eomcs.exception.ex1;

public class Exam0132{

  public static void main(String[] args) {

    int a = Calculator2.compute("+", 234, 61);

    //    System.out.println(a);

    if(a == -1212121212) {
      System.out.println("유효하지 않은 연산자 입니다.");

    }else {

      System.out.println("result:" + a);

    }






  }



}