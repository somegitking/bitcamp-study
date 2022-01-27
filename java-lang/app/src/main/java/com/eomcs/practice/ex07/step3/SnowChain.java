package com.eomcs.practice.ex07.step3;

public class SnowChain extends Option {
  boolean activateSC;



  public SnowChain(Car car) {
    super(car);
    System.out.println("SnowChain 생성자" + car);
    System.out.println("SnowChain 생성자 호출");
  }

  @Override
  public void run() {
    System.out.println("도로 마찰력을 증가시킨다.");
    car.run();
  }




}
