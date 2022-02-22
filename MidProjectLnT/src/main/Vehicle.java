package main;

public abstract class Vehicle {
    protected String type, brand, name, licensenumber;
    protected int topspeed, gascap, wheel;
    
	public Vehicle(String type, String brand, String name, String licensenumber, int topspeed, int gascap, int wheel) {
		super();
		this.type = type;
		this.brand = brand;
		this.name = name;
		this.licensenumber = licensenumber;
		this.topspeed = topspeed;
		this.gascap = gascap;
		this.wheel = wheel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicensenumber() {
		return licensenumber;
	}

	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}

	public int getTopspeed() {
		return topspeed;
	}

	public void setTopspeed(int topspeed) {
		this.topspeed = topspeed;
	}

	public int getGascap() {
		return gascap;
	}

	public void setGascap(int gascap) {
		this.gascap = gascap;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
    
    
}

