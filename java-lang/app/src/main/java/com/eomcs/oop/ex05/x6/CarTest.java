package com.eomcs.oop.ex05.x6;

public class CarTest {

  public static void testSedan(Sedan car) {
    car.start();
    car.run();
    car.stop();

  }

  public static void testTruck(Truck car) {
    car.launch();
    car.go();
    car.stopping();

  }



  public static void main(String[] args) {

    Sedan sedan = new Sedan();
    Truck truck = new Truck();

    testSedan(sedan);
    System.out.println("_____________________");
    testTruck(truck);








  }

}
