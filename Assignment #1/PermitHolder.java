public class PermitHolder extends Person {
	
	private static int idCounter = 1000;
	private final int permitId;
	
	public PermitHolder(String name) {
		super(name);
		this.permitId = idCounter++;
	}
	
	public int getPermitId() {
		return permitId;
	}
	
	@Override
	public String toString() {
		return "[Name: " + name + ", Permit ID: " + permitId + "]";
	}
}
