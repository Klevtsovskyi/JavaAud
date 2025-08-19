package T08;

public class Pair<T1 extends Comparable<T1>, T2 extends Comparable<T2> > 
implements Comparable<Pair<T1, T2> > {
	
	public T1 first;
	public T2 second;
	
	public Pair(T1 f, T2 s) {first = f; second = s;}
	@Override
	public String toString() {return first + ":" + second;}
	
	@Override
	public int compareTo(Pair<T1, T2> other) {
		int res = first.compareTo(other.first);
		if (res == 0) res = second.compareTo(other.second);
		return res;
	}
}
