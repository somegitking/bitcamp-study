package com.eomcs.oop.ex05.x6;

public class BlackBox extends Option {


  public BlackBox(Car car) {
    super(car);
    System.out.println("BlackBox 생성자 호출");
  }

  @Override
  public void run() {
    car.run();
  }

  @Override
  public void start() {
    super.start();
    System.out.println("블랙박스 녹화 시작!");
  }

  @Override
  public void stop() {
    super.stop();
    System.out.println("블랙박스 녹화 종료!");
  }
}
