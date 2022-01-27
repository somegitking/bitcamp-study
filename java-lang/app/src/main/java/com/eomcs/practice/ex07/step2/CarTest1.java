package com.eomcs.practice.ex07.step2;

public class CarTest1 {

  public static void main(String[] args) {

    Sedan sedan = new Sedan();

    Truck truck = new Truck();


    sedan.start();
    sedan.run();
    sedan.stop();

    System.out.println("___________________");

    truck.start();
    truck.run();
    truck.stop();


  }




}
