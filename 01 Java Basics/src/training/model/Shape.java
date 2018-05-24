package training.model;

public interface Shape {
	double PI = 3.1416;
	
	// java 1.8 onwards
	default void info(){
		System.out.println("This is a Shape");
	}
	
	double getArea();
	
}
