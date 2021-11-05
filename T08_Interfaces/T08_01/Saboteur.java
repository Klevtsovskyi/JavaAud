package T08_01;

public class Saboteur implements Spy {
	
	private String destroyedInfo;
	
	public Saboteur() {destroyedInfo = "";}
	
	@Override
	public String toString() {return destroyedInfo;}

	@Override
	public void visit(GeneralStaff generalStaff) {
		destroyedInfo = String.format(
			"Destroyed: %d generals, %d secret papers.", 
			generalStaff.getGenerals(),
			generalStaff.getSecretPapers()
		);
		generalStaff.setGenerals(0);
		generalStaff.setSecretPapers(0);

	}

	@Override
	public void visit(MilitaryBase militaryBase) {
		destroyedInfo = String.format(
			"Destroyed: %d soldiers, %d tanks.", 
			militaryBase.getSoldiers(),
			militaryBase.getTanks()
		);
		militaryBase.setSoldiers(0);
		militaryBase.setTanks(0);
	}

}
