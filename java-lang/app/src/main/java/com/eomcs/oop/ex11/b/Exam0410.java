//static nested class : import static 사용 전
package com.eomcs.oop.ex11.b;

class M {
  // 다른 패키지에서 접근 할 수 있도록 public 으로 공개
  public static int v2;

  public static void m2() {}

  public static class Y {
    public void test() {
      System.out.println("M.Y.test()");
    }
  }
}


class D {
  static int v1;

  static void m1() {}

  static class X {
    void test() {
      System.out.println("test()");
    }
  }
}

public class Exam0410 {

  public static void main(String[] args) {
    // 같은 패키지 클래스
    D.v1 = 100;
    D.m1();
    D.X obj = new D.X();

    // 다른 패키지 클래스
    M.v2 = 200;
    M.m2();
    M.Y obj2 = new M.Y();
  }

}
