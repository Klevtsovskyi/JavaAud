

import java.util.ArrayDeque;
import java.util.Deque;


public class T09_04 {

	public static void main(String[] args) {
		Deque<Integer> stack1 = new ArrayDeque<Integer>();
		Deque<Integer> stack2 = new ArrayDeque<Integer>();
		Deque<Integer> stack3 = new ArrayDeque<Integer>();
		
		for (int i = 0; i < 10; i++)
			stack1.push(i);
		for (int i = 25; i < 30; i++)
			stack2.push(i);

		System.out.println(stack1);
		System.out.println(stack2);
		System.out.println();
		
		int n1 = 0;
		while (!stack1.isEmpty()) {
			stack3.push(stack1.pop());
			n1++;
		}
		int n2 = 0;
		while (!stack2.isEmpty()) {
			stack3.push(stack2.pop());
			n2++;
		}
		
		for (int i = 0; i < n2; i++)
			stack1.push(stack3.pop());
		for (int i = 0; i < n1; i++)
			stack2.push(stack3.pop());
		
		System.out.println(stack1);
		System.out.println(stack2);
	}

}
