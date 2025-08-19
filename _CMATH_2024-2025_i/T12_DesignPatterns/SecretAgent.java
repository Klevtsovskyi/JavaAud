package T12_DesignPatterns;

public class SecretAgent implements Spy {
	
	private String name;
	private String stolenInfo;
	
	public SecretAgent(String name) {this.name = name;}
	
	@Override
	public String toString() {
		return "Secret Agent \"" + name + "\": "
		+ "Stolen info - " + stolenInfo;
	}
	
	@Override
	public void visit(GeneralStaff generalStaff) {
		stolenInfo = "Papers: " + generalStaff.getSecretPapers();
		generalStaff.setSecretPapers(0);
		stolenInfo += ". " + generalStaff.toString();
	}
	
	@Override
	public void visit(MilitaryBase militaryBase) {
		stolenInfo = militaryBase.toString();
	}
}
