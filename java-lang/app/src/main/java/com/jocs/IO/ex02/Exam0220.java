package com.jocs.IO.ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0220 {

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




    byte[] buf = new byte[100];


    int count = in.read(buf);



    System.out.printf("읽은 바이트 수: %d\n", count);

    for (int i = 0; i < count; i++)
      System.out.printf("%02x ", buf[i]);

    System.out.println();


    in.close();
    out.close();



  }




}






