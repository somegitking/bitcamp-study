package com.jocs.IO.ex06;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0320 {

  public static void main(String[] args) throws Exception {

    FileInputStream in = new FileInputStream("temp/jls11.pdf");
    FileOutputStream out = new FileOutputStream("temp/jls11_3.pdf");

    byte[] buf = new byte[8192]; // 보통 8KB 정도 메모리를 준비한다.
    int len = 0;



    while ((len = in.read(buf)) != -1) {
      out.write(buf, 0, len);

    }


    in.close();
    out.close();
  }

}