public class Vehicle {
	
	private static String[]  usedPlates = new String[100];
	private static int totalPlates = 0;
	private String licensePlate;
	private String type;
	private Owner owner;
	
	public Vehicle(String licensePlate, String type, Owner owner) {
		if (isUnique(licensePlate)) {
			this.licensePlate = licensePlate;
			this.type = type;
			this.owner = owner;
			usedPlates[totalPlates++] = licensePlate;
		} else {
			System.out.println("Error: License plate '" + licensePlate + "' already exists.");
		}
	}
	
	private boolean isUnique(String plate) {
		for (int i = 0; i < totalPlates; i++) {
			if (usedPlates[i].equals(plate)) {
				return false;
			}
		}
		return true;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	
	@Override
	public String toString() {
		return "[License Plate: " + licensePlate + ", Type: " + type + ", Owner: " + owner + "]";
	}
}
