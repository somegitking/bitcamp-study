package com.eomcs.practice.ex07.step3;

public class Sedan extends Car {

  Sedan(){
    System.out.println("Sedan 생성자호출");


  }



  @Override
  public void run() {
    System.out.println("세단 달린다");    
  }






}
