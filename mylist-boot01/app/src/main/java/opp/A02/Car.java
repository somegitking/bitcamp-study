package opp.A02;

public class Car {
  public String model;
  public String maker;
  public int capacity;

  public boolean sunroof;
  public boolean auto;

  public Car() {}

  public Car(String model,String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;

    System.out.println(model+ maker+ capacity);

  }

  public Car(String model,String maker, int capacity, boolean sunroof) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
    this.sunroof = sunroof;

    System.out.println(model+ maker+ capacity +sunroof);

  }


  public Car(String model, String maker, int capacity, boolean sunroof, boolean auto) {
    this(model, maker, capacity);

    this.sunroof = sunroof;
    this.auto = auto;

    System.out.println(model+ maker+ capacity +sunroof+auto);

  }



}