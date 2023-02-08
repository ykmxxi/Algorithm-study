package 위상정렬.줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static int[] indeg;
	static ArrayList<Integer>[] adj;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		indeg = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
			indeg[y]++;
		}
	}

	static void pro() {
		Deque<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int x = queue.poll();
			sb.append(x).append(' ');

			for (int y : adj[x]) {
				indeg[y]--;
				if (indeg[y] == 0) {
					queue.add(y);
				}
			}
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
