// 추상 클래스와 추상 메서드
package com.eomcs.oop.ex07.a;


abstract class A2 {


  public abstract void m1();


  //  public abstract void m2() {} // 컴파일 오류!
}

// 일반 클래스(concrete class)
class A2Sub extends A2 {
  @Override
  public void m1() {
    // 서브 클래스에서 추상 메서드를 구현해야 한다.
  }
}

public abstract class Exam02 extends A2 {
  // 서브 클래스에서 추상 메서드를 구현하지 않는다면,
  // 추상 메서드인 채로 남아 있기 때문에
  // 추상 클래스가 되어야 한다.
}
