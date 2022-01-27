package com.jocs.IO.ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0130 {

  //파일에 쓰기

  public static void main(String[] args) throws Exception{

    FileInputStream in = new FileInputStream("temp3/test1.data");
    FileOutputStream out = new FileOutputStream("temp3/test1.data");

    out.write(1);
    out.write(2);
    out.write(3);
    out.write(3);
    out.write(3);
    out.write(3);


    int b;

    while((b = in.read()) != -1) {

      System.out.printf("%x\n", b);
    }



  }





}
