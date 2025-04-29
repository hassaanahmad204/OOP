public class Supervisor extends Person {
	
	private int experience;
	
	public Supervisor(String name, int experience) {
		super(name);
		this.experience = experience;
	}
	
	public int getExperience() {
		return experience;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Experience: " + experience + " years";
	}
}
