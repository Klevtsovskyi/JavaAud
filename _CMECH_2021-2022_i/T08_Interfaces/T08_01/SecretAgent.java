package T08_01;

public class SecretAgent implements Spy {
	
	private String stolenInfo;
	
	public SecretAgent() {stolenInfo = "";}
	
	@Override
	public String toString() {return stolenInfo;}

	@Override
	public void visit(GeneralStaff generalStaff) {
		stolenInfo = String.format(
			"%d secret papers were stolen.\n",
			generalStaff.getSecretPapers()
		);
		generalStaff.setSecretPapers(0);
		stolenInfo += String.format(
			"Information: %s", generalStaff
		);
	}

	@Override
	public void visit(MilitaryBase militaryBase) {
		stolenInfo = String.format(
			"Information: %s", militaryBase
		);

	}

}
