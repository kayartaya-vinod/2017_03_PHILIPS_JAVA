package training.programs;

import training.model.Circle;
import training.model.InvalidParamException;
import training.model.Shape;
import training.model.Triangle;

public class P02_TestingInterfaces {
	public static void main(String[] args) {
		
		Triangle t1 = new Triangle(12.0, 34.0);
		
		System.out.println("t1 instancoef Triangle is " + (t1 instanceof Triangle));
		System.out.println("t1 instancoef Shape is " + (t1 instanceof Shape));
		System.out.println("t1 instancoef Object is " + (t1 instanceof Object));
		
		Shape s1;
		s1 = t1;
		s1.info();
		System.out.println("Area of s1 is " + s1.getArea());
		
		try {
			s1 = new Circle(-12);
			s1.info(); // calls the default method of Shape interface (only java 1.8+)
			System.out.println("Area of s1 is " + s1.getArea());
		} catch (InvalidParamException e) {
			System.err.println(e.getMessage());
		}
		
	}
}





