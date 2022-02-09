package com.eomcs.test;

public class Test {
  public static void main(String[] args) throws Exception {

    String str = "1 2 3 4 5 6 6";

    String[] str1 = str.split(" ");

    for(int i =0 ; i< str1.length; i++) {
      System.out.println(str1[i]);
    }



  }

}
