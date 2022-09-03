package T08_01;

public interface MilitaryObject {
	
	public default void accept(Spy spy) {
		spy.visit(this);
	}
	
}
