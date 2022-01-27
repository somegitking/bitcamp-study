package com.eomcs.practice.classexam;

public class Class01 {

}

class Class02 extends Class01 {

  void a(Class01 class01) {

  }

}


class Class03 extends Class02 {

  public static void main(String[] args) {
    Class03 class03 = new Class03();

    class03.a(new Class03());
  }

}
