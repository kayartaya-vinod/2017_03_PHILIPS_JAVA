package training.model;

public class Circle implements Shape {

	private double radius;

	public Circle() {
	}

	public Circle(double radius) throws InvalidParamException {
		setRadius(radius);
	}

	public void setRadius(double radius) throws InvalidParamException {
		if(radius<0){
			throw new InvalidParamException("Radius must be >=0");
		}
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getArea() {
		return PI * radius * radius;
	}

}
