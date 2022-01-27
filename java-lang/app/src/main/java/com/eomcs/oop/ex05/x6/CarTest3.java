package com.eomcs.oop.ex05.x6;

public class CarTest3 {
  public static void main(String[] args) {
    //    Sedan sedan = new Sedan();
    //
    //    SnowChain snowChain= new SnowChain(sedan);
    //
    //    testCar(snowChain);



    //    Truck truck = new Truck();
    //
    //    BlackBox blackBox = new BlackBox(truck);
    //
    //    testCar(blackBox);

    System.out.println("1-----------------------------");

    SUV suv = new SUV();
    suv.active4wd(true);
    System.out.println("2-----------------------------");

    SnowChain snowChainSuv = new SnowChain(suv);
    System.out.println("3-----------------------------");

    BlackBox blackBoxSuv = new BlackBox(snowChainSuv);
    System.out.println("4-----------------------------");

    testCar(blackBoxSuv);
    System.out.println("5-----------------------------");

  }

  static void testCar(Car car) {
    System.out.println("testCar 실행");
    System.out.println(car);
    System.out.println("-----------------------------");


    System.out.println("6-----------------------------");
    car.run();
    System.out.println("7-----------------------------");
    car.stop();
  }
}
