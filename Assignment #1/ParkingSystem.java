import java.util.*;

public class ParkingSystem {
    private static ParkingSystem instance;
    private final String campusName;
    private final Supervisor supervisor;
    private final List<ParkingZone> zones = new ArrayList<>();
    private final List<PermitHolder> permitHolders = new ArrayList<>();

    private ParkingSystem(String campusName, Supervisor supervisor) {
        this.campusName = campusName;
        this.supervisor = supervisor;
    }

    public static ParkingSystem getInstance(String name, Supervisor supervisor) {
        if (instance == null) {
            instance = new ParkingSystem(name, supervisor);
        } else {
            System.out.println("Warning: ParkingSystem instance already exists. Returning existing instance.");
        }
        return instance;
    }

    public void addZone(ParkingZone zone) {
        zones.add(zone);
    }
	
    public void addPermitHolder(PermitHolder ph) {
        permitHolders.add(ph);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Campus: " + campusName + "\n");
        sb.append("Supervisor: ").append(supervisor).append("\n");
        sb.append("Zones:\n");
        for (ParkingZone z : zones) {
            sb.append(z).append("\n");
        }
        sb.append("Permit Holders:\n");
        for (PermitHolder p : permitHolders) {
            sb.append(p).append(", ");
        }
        return sb.toString();
    }
}
