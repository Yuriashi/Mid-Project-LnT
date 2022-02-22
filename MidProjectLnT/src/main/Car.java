package main;

public class Car extends Vehicle {

	protected int entertainmentSystem;
	
	public Car(String type, String brand, String name, String licensenumber, int topspeed, int gascap, int wheel, int entertainmentSystem) {
		super(type, brand, name, licensenumber, topspeed, gascap, wheel);
		this.entertainmentSystem = entertainmentSystem;
	}

	public int getEntertainmentSystem() {
		return entertainmentSystem;
	}

	public void setEntertainmentSystem(int entertainmentSystem) {
		this.entertainmentSystem = entertainmentSystem;
	}
	
	

}
