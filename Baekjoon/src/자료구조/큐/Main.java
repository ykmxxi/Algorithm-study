package 자료구조.큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, X;
	static MyQueue<Integer> myQueue;

	static void pro(String command) {
		if (command.equals("push")) {
			myQueue.push(X);
		} else if (command.equals("pop")) {
			myQueue.pop();
		} else if (command.equals("size")) {
			myQueue.size();
		} else if (command.equals("empty")) {
			myQueue.empty();
		} else if (command.equals("front")) {
			myQueue.front();
		} else if (command.equals("back")) {
			myQueue.back();
		}
	}

	public static void main(String[] args) throws IOException {
		myQueue = new MyQueue<>(new LinkedList<>());

		N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			if (st.hasMoreTokens()) {
				X = Integer.parseInt(st.nextToken());
			}

			pro(command);
		}

		System.out.println(sb);
	}

	static class MyQueue<T> {
		private final LinkedList<T> queue;

		public MyQueue(LinkedList<T> queue) {
			this.queue = queue;
		}

		public void push(T X) {
			queue.offer(X);
		}

		public void pop() {
			if (queue.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(queue.poll()).append('\n');
			}
		}

		public void size() {
			sb.append(queue.size()).append('\n');
		}

		public void empty() {
			if (queue.isEmpty()) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}

		public void front() {
			if (queue.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(queue.peek()).append('\n');
			}
		}

		public void back() {
			if (queue.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(queue.peekLast()).append('\n');
			}
		}
	}
}
