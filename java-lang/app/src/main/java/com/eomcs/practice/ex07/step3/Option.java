package com.eomcs.practice.ex07.step3;

public abstract class Option extends Car {


  Car car;

  Option(Car car) {
    System.out.println("Option 생성자");
    System.out.println("Option 생성자" + car); 
    this.car = car;
  }

  @Override
  public void start() {
    // 데코레이터는 자동차가 아니다.
    // 따라서 시동을 걸라고 요청이 들어오면
    // 실제 자동차 객체에게 위임해야 한다.
    car.start();
  }

  @Override
  public void stop() {
    // 데코레이터는 자동차가 아니다.
    // 따라서 시동을 끄라고 요청이 들어오면
    // 실제 자동차 객체에게 위임해야 한다.
    car.stop();

  }
}