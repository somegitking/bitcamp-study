// 버퍼 사용 후 - 데이터 읽는데 걸린 시간 측정
package com.jocs.IO.ex06;

import java.io.FileInputStream;

public class Exam0121{

  public static void main(String[] args) throws Exception {

    FileInputStream in = new FileInputStream("temp/jls11.pdf");

    byte[] buf = new byte[8096];
    int count = 0;

    while(in.read(buf) != -1) {

      System.out.println(count++);


    }

    in.close();






  }


}