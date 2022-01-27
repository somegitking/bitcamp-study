package com.jocs.IO.ex06;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0321x{
  public static void main(String[] args)throws Exception {

    FileInputStream in = new FileInputStream("temp/ljs11.pdf");
    FileOutputStream out = new FileOutputStream("temp/ljs12.pdf");

    byte[] buf = new byte[8196];
    int len = 0;

    while((len = in.read(buf)) != -1) {

      out.write(buf, 0, len );

    }

    in.close();
    out.close();






  }



}