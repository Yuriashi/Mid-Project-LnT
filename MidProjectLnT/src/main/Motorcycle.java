package main;

public class Motorcycle extends Vehicle {

	protected int helm;
	
	public Motorcycle(String type, String brand, String name, String licensenumber, int topspeed, int gascap, int wheel, int helm) {
		super(type, brand, name, licensenumber, topspeed, gascap, wheel);
		
		this.helm = helm;
	}

	public int getHelm() {
		return helm;
	}

	public void setHelm(int helm) {
		this.helm = helm;
	}

}
