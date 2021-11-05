package T08_01;

public class MilitaryBase implements MilitaryObject {
	
	private String title;
	private int soldiers;
	private int tanks;
	
	public MilitaryBase(String title, int soldiers, int tanks) {
		this.title = title;
		this.soldiers = soldiers;
		this.tanks = tanks;
	}
	
	public int getSoldiers() {return soldiers;}
	public void setSoldiers(int soldiers) {this.soldiers = soldiers;}
	public int getTanks() {return tanks;}
	public void setTanks(int tanks) {this.tanks = tanks;}
	public String getTitle() {return title;}
	
	@Override
	public String toString() {
		return String.format(
			"Military base \"%s\" has %d soldiers and %d tanks.",
			getTitle(), getSoldiers(), getTanks()
		);
	}

}
