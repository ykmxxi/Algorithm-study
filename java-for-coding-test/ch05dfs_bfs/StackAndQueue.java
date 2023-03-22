package ch05dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {

	public static void main(String[] args) {
		Stack<Integer> integerStack = new Stack<>();

		integerStack.push(5); // 5
		integerStack.push(2); // 2 5
		integerStack.push(3); // 3 2 5
		integerStack.push(7); // 7 3 2 5
		integerStack.pop(); // 3 2 5
		integerStack.push(1); // 1 3 2 5
		integerStack.push(4); // 4 1 3 2 5
		integerStack.pop(); // 1 3 2 5

		System.out.print("Stack: ");
		while (!integerStack.isEmpty()) {
			System.out.print(integerStack.peek() + " ");
			integerStack.pop();
		}
		System.out.println();

		Queue<Integer> integerQueue = new LinkedList<>();

		integerQueue.offer(5); // 5
		integerQueue.offer(2); // 5 2
		integerQueue.offer(3); // 5 2 3
		integerQueue.offer(7); // 5 2 3 7
		integerQueue.poll(); // 2 3 7
		integerQueue.offer(1); // 2 3 7 1
		integerQueue.offer(4); // 2 3 7 1 4
		integerQueue.poll(); // 3 7 1 4

		System.out.print("Queue: ");
		while (!integerQueue.isEmpty()) {
			System.out.print(integerQueue.poll() + " ");
		}
	}

}
