package com.eomcs.oop.ex06.a;

public class Exam0520{

  public void print(Vehicle v) {

    System.out.println("[기본정보]");

    System.out.printf("Model: %s\n", v.model);
    System.out.printf("Capacity: %d\n", v.capacity);

    if(v instanceof Bike) {
      System.out.println("It is bike");
      Bike bike = (Bike) v;
      System.out.println("[바이크 정보]");
      System.out.printf("엔진의 존재: %b\n", bike.engine);
    }else if(v instanceof Sedan){
      System.out.println("It is Sedan");
    }else {
      System.out.println("It is Truck");
    }








  }


  public static void main(String[] args) {

    Bike bike = new Bike("야마하",1,true);
    Sedan sedan = new Sedan("렉서스",5,900,20,true,true);
    Truck truck = new Truck("포터",3,10000,32,14,false);

    Exam0520 ex = new Exam0520();
    ex.print(bike);
    ex.print(sedan);
    ex.print(truck);

  }


}