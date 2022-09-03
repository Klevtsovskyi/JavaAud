package T08_01;

public interface Spy {
	
	public default void visit(MilitaryObject militaryObject) {
		if (militaryObject instanceof GeneralStaff)
			visit((GeneralStaff) militaryObject);
		else if (militaryObject instanceof MilitaryBase)
			visit((MilitaryBase) militaryObject);
	};
	
	public void visit(GeneralStaff generalStaff);
	public void visit(MilitaryBase militaryBase);
	
}
