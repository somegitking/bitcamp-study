package com.jocs.IO.ex02;

import java.io.FileOutputStream;

public class Exam0110 {

  //파일에 쓰기

  public static void main(String[] args) throws Exception{
    FileOutputStream out = new FileOutputStream("temp3/test1.data");

    out.write(12);
    out.write(13);
    out.write(14);

    out.close();

  }





}
