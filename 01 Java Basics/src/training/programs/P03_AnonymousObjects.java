package training.programs;

import training.model.Shape;

public class P03_AnonymousObjects {
	public static void main(String[] args) {
		// interface is REALIZED using an object 
		// of a class that implements the interface
		
		Shape s1 = new Shape(){
			@Override
			public double getArea() {
				return 0;
			}};
		s1.info();
	}
}
