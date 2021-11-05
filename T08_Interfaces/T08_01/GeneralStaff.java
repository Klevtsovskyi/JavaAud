package T08_01;

public class GeneralStaff implements MilitaryObject {

	private String title;
	private int secretPapers;
	private int generals;
	
	public GeneralStaff(String title, int secretPapers, int generals) {
		this.title = title;
		this.secretPapers = secretPapers;
		this.generals = generals;
	}
	
	public int getGenerals() {return generals;}
	public int getSecretPapers() {return secretPapers;}
	public void setGenerals(int generals) {this.generals = generals;}
	public void setSecretPapers(int secretPapers) {this.secretPapers = secretPapers;}
	public String getTitle() {return title;}
	
	@Override
	public String toString() {
		return String.format(
			"General Staff \"%s\" has %d generals and %d secret papers.",
			getTitle(), getGenerals(), getSecretPapers()
		);
	}
}
