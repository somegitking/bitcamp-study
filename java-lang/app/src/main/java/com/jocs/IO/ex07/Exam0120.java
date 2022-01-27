package com.jocs.IO.ex07;

import com.eomcs.io.ex07.DataBufferedFileOutputStream;

public class Exam0120 {
  public static void main(String[] args) throws Exception{
    DataBufferedFileOutputStream out = new DataBufferedFileOutputStream("temp/members1.data");

    Member member = new Member();
    member.name = "AB가각간";
    member.age = 27;
    member.gender = true;

    long start = System.currentTimeMillis();
    long end = System.currentTimeMillis();


  }








}
