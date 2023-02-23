package 자료구조.덱;

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
	static MyDeque<Integer> dq;

	static void pro(String command) {
		switch (command) {
			case "push_back":
				dq.push_back(X);
				break;
			case "push_front":
				dq.push_front(X);
				break;
			case "pop_back":
				dq.pop_back();
				break;
			case "pop_front":
				dq.pop_front();
				break;
			case "size":
				dq.size();
				break;
			case "empty":
				dq.empty();
				break;
			case "front":
				dq.front();
				break;
			case "back":
				dq.back();
				break;
		}
	}

	public static void main(String[] args) throws IOException {
		dq = new MyDeque<Integer>(new LinkedList<>());
		N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();

			if (st.hasMoreTokens()) {
				X = Integer.parseInt(st.nextToken());
			}

			pro(command);
		}

		System.out.print(sb);
	}

	static class MyDeque<E> {
		private final LinkedList<E> dq;

		public MyDeque(LinkedList<E> dq) {
			this.dq = dq;
		}

		public void push_front(E X) {
			dq.addFirst(X);
		}

		public void push_back(E X) {
			dq.addLast(X);
		}

		public void pop_front() {
			if (dq.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(dq.peek()).append('\n');
				dq.removeFirst();
			}
		}

		public void pop_back() {
			if (dq.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(dq.peekLast()).append('\n');
				dq.removeLast();
			}
		}

		public void size() {
			sb.append(dq.size()).append('\n');
		}

		public void empty() {
			if (dq.isEmpty()) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}

		public void front() {
			if (dq.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(dq.peek()).append('\n');
			}
		}

		public void back() {
			if (dq.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(dq.peekLast()).append('\n');
			}
		}
	}
}
