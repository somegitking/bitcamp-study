package com.eomcs.practice.ex07.step3;

public class CarTest1 {

  static void testCar(Car car) {
    System.out.println("5-0______________________");
    System.out.println(car);
    System.out.println("5______________________");

    car.start();
    System.out.println("6______________________");

    car.run();
    System.out.println("7______________________");

    car.stop();
    System.out.println("8______________________");


  }

  public static void main(String[] args) {


    //    testCar(sedan);

    //    System.out.println("______________________");

    //    testCar(truck);


    System.out.println("1______________________");
    Sedan sedan1 = new Sedan();
    System.out.println("2______________________");

    SnowChain snowChain = new SnowChain(sedan1);
    System.out.println("__________________________"
        + "");
    System.out.println("실험" +new SnowChain(sedan1));

    System.out.println("3______________________");

    System.out.println(snowChain);
    testCar(snowChain);
    System.out.println("4______________________");

  }




}
