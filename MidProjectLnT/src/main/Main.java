package main;

import java.util.ArrayList;
import java.util.Scanner;

import main.Car;
import main.Motorcycle;
import main.Vehicle;

public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

	public Main() {

		int choose = -1;

		do {
			System.out.println("================");
			System.out.println("MENU");
			System.out.println("================");
			System.out.println("1. Input");
			System.out.println("2. View");
			System.out.println("3. Exit");
			System.out.print(">> ");

			choose = scan.nextInt();
			scan.nextLine();

			switch (choose) {
			case 1:
				input();
				break;
			case 2:
				view();
				break;
			}
		} while (choose != 3);
	}

	private void view() {
		System.out.println("|-----|----------|--------------------|");
		System.out.printf("|%-5s|%-10s|%-20s|\n", "No", "Type", "Name");
		System.out.println("|-----|----------|--------------------|");
		int counter = 0;
		for (Vehicle vehicle : vehicleList) {
			counter++;
			String type = "";
			if (vehicle instanceof Car)
				type = "Car";
			else
				type = "Motorcycle";
			System.out.printf("|%-5d|%-10s|%-20s|\n", counter, type, vehicle.getName());
		}
		System.out.println("|-----|----------|--------------------|");

		int number = -1;
		do {
			System.out.print("Pick a vehicle number to test drive[Enter '0' to exit]: ");
			number = scan.nextInt();
			scan.nextLine();

			if (number == 0)
				return;

		} while (number < 1 || number > vehicleList.size());
		printDetail(vehicleList.get(number - 1));
	}

	private void printDetail(Vehicle v) {
		System.out.printf("Brand: %s\n", v.getBrand());
		System.out.printf("Name: %s\n", v.getName());
		System.out.printf("License Plate: %s\n", v.getLicensenumber());
		System.out.printf("Type: %s\n", v.getType());
		System.out.printf("Gas Capacity: %s\n", v.getGascap());
		System.out.printf("Top Speed: %d\n", v.getTopspeed());
		System.out.printf("Wheel(s): %d\n", v.getWheel());

		if (v instanceof Car) {
			System.out.printf("Entertainment System: %d\n", ((Car) v).getEntertainmentSystem());
			System.out.println("Turning on entertainment system...");
			if (v.getType().equals("Supercar"))
				System.out.println("Boosting!");
		} else if (v instanceof Motorcycle) {
			System.out.printf("Helm: %d\n", ((Motorcycle) v).getHelm());
			System.out.printf("%s is standing!\n", v.getName());
			int price = 0;
			System.out.print("Helm price: ");
			price = scan.nextInt(); scan.nextLine();
			System.out.println("Price: " + price);
		}
	}

	private boolean validateLicensePlate(String plate) {
		plate = plate.trim();
		if(plate.length() < 5)
			return false;
		
		if (!(plate.charAt(0) >= 'A' && plate.charAt(0) <= 'Z'))
			return false;
		
		if (plate.charAt(1) != ' ')
			return false;

		int numberCounter = 0;
		for (int i = 0; i < plate.length(); i++) {
			if (plate.charAt(i) >= '1' && plate.charAt(i) <= '9')
				numberCounter++;
		}
		if (numberCounter < 1 || numberCounter > 4)
			return false;

		int endingCounter = 0;
		for (int i = plate.length()-1; i >= 0 && plate.charAt(i) != ' '; i--) {
			if (plate.charAt(i) >= 'A' && plate.charAt(i) <= 'Z')
				endingCounter++;
		}

		if (endingCounter < 1 || endingCounter > 3)
			return false;

		return true;
	}

	private void input() {
		String type = "";
		do {
			System.out.println("Input type [Car | Motorcycle] : ");
			type = scan.nextLine();
		} while (!type.equals("Car") && !type.equals("Motorcycle"));

		String brand = "";
		do {
			System.out.println("Input brand [>= 5] : ");
			brand = scan.nextLine();
		} while (brand.length() < 5);

		String name = "";
		do {
			System.out.println("Input name [>= 5] : ");
			name = scan.nextLine();
		} while (name.length() < 5);

		String licenseNumber = "";
		do {
			System.out.println("Input license : ");
			licenseNumber = scan.nextLine();
		} while (!validateLicensePlate(licenseNumber));

		int topSpeed = 0;
		do {
			System.out.println("Input top speed [100 <= topSpeed <= 250] : ");
			topSpeed = scan.nextInt();
			scan.nextLine();
		} while (topSpeed < 100 || topSpeed > 250);

		int gasCap = 0;
		do {
			System.out.println("Input gas capacity [30 <= gasCap <= 60] : ");
			gasCap = scan.nextInt();
			scan.nextLine();
		} while (gasCap < 30 || gasCap > 60);

		int wheel = 0;

		if (type.equals("Car")) {
			do {
				System.out.println("Input wheel [4 <= wheel <= 6]");
				wheel = scan.nextInt();
				scan.nextLine();
			} while (wheel < 4 || wheel > 6);

			String jenis = "";
			do {
				System.out.println("Input type [SUV | Supercar | Minivan] : ");
				jenis = scan.nextLine();
			} while (!jenis.equals("SUV") && !jenis.equals("Supercar") && !jenis.equals("Minivan"));

			int entertainment = 0;
			do {
				System.out.println("Input entertaiment system amount [>= 1] : ");
				entertainment = scan.nextInt();
				scan.nextLine();
			} while (entertainment < 1);

			vehicleList.add(new Car(jenis, brand, name, licenseNumber, topSpeed, gasCap, wheel, entertainment));

		} else {
			do {
				System.out.println("Input wheel [2 <= wheel <= 3]");
				wheel = scan.nextInt();
				scan.nextLine();
			} while (wheel < 2 || wheel > 3);

			String jenis = "";
			do {
				System.out.println("Input type [Automatic | Manual] : ");
				jenis = scan.nextLine();
			} while (!jenis.equals("Automatic") && !jenis.equals("Manual"));

			int helm = 0;
			do {
				System.out.println("Input helm amount [>= 1] : ");
				helm = scan.nextInt();
				scan.nextLine();
			} while (helm < 1);

			vehicleList.add(new Motorcycle(jenis, brand, name, licenseNumber, topSpeed, gasCap, wheel, helm));
		}

		System.out.print("ENTER to return");
		scan.nextLine();
	}

	public static void main(String[] args) {
		new Main();
	}
}
