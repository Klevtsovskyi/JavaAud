

import java.util.PriorityQueue;


public class T09_05 {

	public static void main(String[] args) {
		PriorityQueue<Pair<Integer, String> > pq =
			new PriorityQueue<>();
		
		pq.add(new Pair<Integer, String>(100, "abc"));
		pq.add(new Pair<Integer, String>(70, "zxc"));
		pq.add(new Pair<Integer, String>(100, "wer"));
		pq.add(new Pair<Integer, String>(30, "yui"));
		
		while (!pq.isEmpty())
			System.out.println(pq.poll().second);
	}

}


class Pair<T1 extends Comparable<T1>, T2 extends Comparable<T2> > 
	implements Comparable<Pair<T1, T2> > {
	
	public T1 first;
	public T2 second;
	
	Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int compareTo(Pair<T1, T2> other) {
		int res = this.first.compareTo(other.first);
		if (res == 0)
			res = this.second.compareTo(other.second);
		return res;
	}
}