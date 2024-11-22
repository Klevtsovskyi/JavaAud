package T12_DesignPatterns;

public class Saboteur implements Spy {
	
	private String name;
	private String destroyedInfo;
	
	public Saboteur(String name) {this.name = name;}
	
	@Override
	public String toString() {
		return "Saboteur \"" + name + "\": "
		+ "Destroyed - " + destroyedInfo;
	}
	
	@Override
	public void visit(GeneralStaff generalStaff) {
		destroyedInfo = "generals: " + generalStaff.getGenerals()
		+ ", secret papers: " + generalStaff.getSecretPapers();
		generalStaff.setGenerals(0);
		generalStaff.setSecretPapers(0);
	}
	
	@Override
	public void visit(MilitaryBase militaryBase) {
		destroyedInfo = "soldiers: " + militaryBase.getSoldiers()
		+ ", tanks: " + militaryBase.getTanks();
		militaryBase.setSoldiers(0);
		militaryBase.setTanks(0);
	}
}
