package 자료구조.요세푸스문제;
/*
	1 부터 N명 까지 있을 때, 원을 이루고 앉아 있음
	K 번째 사람을 순서대로 제거, 한 사람이 제거되면 이루어진 원을 따라 모두 제거할떄 까지 반복
 */

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, K;
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}

	static void pro() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		sb.append('<');

		while (q.size() != 1) {
			for (int i = 0; i < K - 1; i++) {
				int cur = q.poll();
				q.add(cur);
			}
			sb.append(q.poll()).append(", ");
		}

		sb.append(q.poll()).append('>');

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
