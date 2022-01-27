package com.eomcs.oop.ex05.x6;

public class SnowChain extends Option {

  public SnowChain(Car car) {
    super(car);

    System.out.println("SnowChain 생성자");
  }

  @Override
  public void run() {
    System.out.println("snow chain class 도로 마찰력을 증가시킨다.");
    System.out.println("car. 주소: " +car);
    car.run();
  }
}
