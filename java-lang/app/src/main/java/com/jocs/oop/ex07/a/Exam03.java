package com.jocs.oop.ex07.a;

abstract class A3{
  public abstract void m1();
}

class A3Sub extends A3{
  @Override
  public void m1() {
    System.out.println("A3Sub.m1() 호출됨");
  }

  public void m2() {
    System.out.println("A3Sub.m2() 호출됨");
  }
}

public class Exam03{
  public static void main(String[] args) {
    A3 obj;

    obj = new A3Sub();

    obj.m1();
    //    obj.m2(); 컴파일러 차원에서 에러 왜냐? 


  }
}