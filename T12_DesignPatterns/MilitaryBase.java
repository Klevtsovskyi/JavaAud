package T12_DesignPatterns;

public class MilitaryBase implements MilitaryObject {
	
	private String name;
	private int soldiers;
	private int tanks;
	
	public MilitaryBase(String name, int soldiers, int tanks) {
		this.name = name;
		this.soldiers = soldiers;
		this.tanks = tanks;
	}
	
	public String getName() {return name;}
	public int getSoldiers() {return soldiers;}
	public void setSoldiers(int soldiers) {this.soldiers = soldiers;}
	public int getTanks() {return tanks;}
	public void setTanks(int tanks) {this.tanks = tanks;}
	
	@Override
	public String toString() {
		return "Military Base: \"" + name + "\": "
		+ "soldiers - " + soldiers + ", tanks - " + tanks;
	}

	@Override
	public void accept(Spy spy) {
		spy.visit(this);		
	}
}
