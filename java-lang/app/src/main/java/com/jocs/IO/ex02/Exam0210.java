package com.jocs.IO.ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0210 {

  //파일에 쓰기

  public static void main(String[] args) throws Exception{

    FileInputStream in = new FileInputStream("temp3/test1.data");
    FileOutputStream out = new FileOutputStream("temp3/test1.data");


    byte[] bytes = {23, 24,2, 34,23,2,4};

    out.write(bytes);

    int b;

    while((b = in.read()) != -1) {

      System.out.printf("%d ", b);


    }



    out.close();




  }





}
