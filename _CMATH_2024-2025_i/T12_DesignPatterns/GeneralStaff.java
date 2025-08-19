package T12_DesignPatterns;

public class GeneralStaff implements MilitaryObject {
	
	private String name;
	private int generals;
	private int secretPapers;
	
	public GeneralStaff(String name, int generals, int secretPapers) {
		this.name = name;
		this.generals = generals;
		this.secretPapers = secretPapers;
	}
	
	public String getName() {return name;}
	public int getGenerals() {return generals;}
	public void setGenerals(int generals) {this.generals = generals;}
	public int getSecretPapers() {return secretPapers;}
	public void setSecretPapers(int secretPapers) {this.secretPapers = secretPapers;}
	
	@Override
	public String toString() {
		return "General Staff \"" + name + "\": "
		+ "generals - " + generals + ", secret papers - " + secretPapers;
	}

	@Override
	public void accept(Spy spy) {
		spy.visit(this);
	}
}
