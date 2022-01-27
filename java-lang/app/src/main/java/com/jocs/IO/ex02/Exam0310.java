package com.jocs.IO.ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0310 {

  //파일에 쓰기

  public static void main(String[] args) throws Exception{

    String str = new String("AB가각");

    System.out.printf("file.encoding=%s\n", System.getProperty("file.encoding"));
    byte[] bytes = str.getBytes(); //문자열을 16진수 BYTES로 변환, 영어는 1바이트, 한글은 2바이트


    for (byte b : bytes) {
      System.out.printf("%x ", b);
    }

    System.out.println();


    //Java 프로그램을 기준으로 out. 외부파일에 write()

    FileOutputStream out = new FileOutputStream("temp/utf.txt");

    //Java 프로그램을 기준으로 out. 외부파일에 write()
    out.write(bytes);
    out.close();

    //Java 프로그램을 기준으로 in 외부파일로 부터 읽어 들임 read()
    FileInputStream in = new FileInputStream("temp/utf.txt");


    System.out.printf("%s",in.read());
    System.out.printf("%s",in.read());
    System.out.printf("%s",in.read());
    System.out.printf("%s",in.read());



  }


}






