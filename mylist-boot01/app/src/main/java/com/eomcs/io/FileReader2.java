package com.eomcs.io;

import java.io.FileReader;

// 기존 코드를 자신의 코드인양 사용하겠다고 선언한다.
public class FileReader2 {
  //기존의 클래스 포함
  FileReader in;


  // 기존 객체를 준비한다.
  public FileReader2(String filename) throws Exception {


    in = new FileReader(filename);
  }

  public String readLine() throws Exception{
    StringBuilder buf = new StringBuilder();
    int c;

    while((c = in.read()) != -1) {
      if(c == '\n') {
        return buf.toString();
      }else if(c == '\n') {

      }else {
        buf.append((char) c);
      }
    }
    return buf.toString();
  }

  public void close() throws Exception{
    in.close();
  }


}
