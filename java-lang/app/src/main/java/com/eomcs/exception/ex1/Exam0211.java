package com.eomcs.exception.ex1;

import java.util.Scanner;

public class Exam0211{

  public static void main(String[] args) {

    Scanner keyScan = new Scanner(System.in);

    while(true) {
      System.out.println(">");
      int v1 = keyScan.nextInt();

      String op = keyScan.next();
      if(op.equalsIgnoreCase("quit"))
        break;

      int v2 = keyScan.nextInt();

      int result = Calculator3.compute(v1,op,  v2);

      System.out.println("RESUTL: " +result);




    }









  }
}