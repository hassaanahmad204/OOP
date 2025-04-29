import java.util.*;

public class ParkingZone {
	private static int zoneCounter = 1;
	private final String zoneId;
	private final Vehicle[] vehicles = new Vehicle[5];
	
	public ParkingZone() {
		this.zoneId = "Z" + zoneCounter++;
	}
	
	public boolean addVehicle(Vehicle vehicle) {
		if (vehicle.getLicensePlate() == null) return false;
		
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] == null) {
				vehicles[i] = vehicle;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Zone ID: " + zoneId + ", Vehicles: ");
		for (Vehicle v : vehicles) {
			sb.append(v != null ? v.toString() : "null").append(", ");
		}
		return sb.substring(0, sb.length() - 2);
	}
}
