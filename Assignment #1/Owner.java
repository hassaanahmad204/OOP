public class Owner extends Person {
	
	private static int counter = 1;
	private final int ownerId;
	
	public Owner(String name) {
		super(name);
		this.ownerId = counter++;
	}
	
	public int getOwnerId() {
		return ownerId;
	}
	
	@Override
	public String toString() {
		return "[Name: " + name + ", Owner ID: " + String.format("%04d", ownerId) + "]";
	}
}
