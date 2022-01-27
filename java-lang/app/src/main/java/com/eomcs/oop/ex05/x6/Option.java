package com.eomcs.oop.ex05.x6;

public abstract class Option extends Car {
  Car car;

  public Option(Car car) {
    System.out.println("Option 생성자");
    System.out.println(car);
    this.car = car;
  }
  ;
  @Override
  public void start() {
    // 데코레이터는 자동차가 아니다.
    // 따라서 시동을 걸라고 요청이 들어오면
    // 실제 자동차 객체에게 위임해야 한다.
    System.out.println("Option start()");
    System.out.println(car);
    car.start();
  }

  @Override
  public void stop() {
    // 데코레이터는 자동차가 아니다.
    // 따라서 시동을 끄라고 요청이 들어오면
    // 실제 자동차 객체에게 위임해야 한다.
    System.out.println("Option stop()");
    System.out.println(car);
    car.stop();
  }
}
