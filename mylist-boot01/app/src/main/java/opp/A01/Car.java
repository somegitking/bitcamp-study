package opp.A01;

public class Car {
  public String model;
  public String maker;
  public int capacity;

  public Car() {}

  public Car(String model,String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
    System.out.printf("this.model: %s, ",this.model);
    System.out.printf("this.maker: %s, ",this.maker);
    System.out.printf("this.capacity: %s\n",this.capacity);
  }

  public void run() {
    System.out.println("달린다.");

  }



}
