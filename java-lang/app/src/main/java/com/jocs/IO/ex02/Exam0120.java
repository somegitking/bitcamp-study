package com.jocs.IO.ex02;

import java.io.FileInputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception{

    FileInputStream in = new FileInputStream("temp3/test1.data");


    int b = in.read();

    System.out.printf("%02x\n", b);
    System.out.printf("%02x\n", in.read());
    System.out.printf("%02x\n", in.read());
    System.out.printf("%02x\n", in.read());


  }






}
