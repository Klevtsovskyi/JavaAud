package T08;

import java.util.PriorityQueue;

public class A08_05 {

	public static void main(String[] args) {
		PriorityQueue<Pair<Integer, String> > queue = new PriorityQueue<>();
		queue.add(new Pair<Integer, String>(843, "ZXC"));
		queue.add(new Pair<Integer, String>(543, "FCC"));
		queue.add(new Pair<Integer, String>(543, "AAA"));
		queue.add(new Pair<Integer, String>(432, "AAA"));
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
