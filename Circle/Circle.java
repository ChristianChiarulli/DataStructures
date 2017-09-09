//package Circle;

import java.util.ArrayList;
import java.util.List;

public class Circle {

  private double radius;
  public static final double PI = 3.14159;


  //constructor
  public Circle(double radius){
    this.radius = radius;
  }

  // method to find area
  public double getArea(){
    return PI * this.radius*this.radius;
  }

  public String toString() {
    return "Circle [radius=" + this.radius + "]";
  }

  public static void main(String[] args) {
    //<this is the generic>
    List<Circle> list = new ArrayList<Circle>();

    for (int i = 1; i <=1000; i++){
      Circle c = new Circle(i);
      list.add(c);
    }
    for (int i = 1; i < list.size(); i++){
      Circle c = list.get(i);
      System.out.println(c.getArea());
    }
  }
}

// String.length()
// array.length
// list.size()
