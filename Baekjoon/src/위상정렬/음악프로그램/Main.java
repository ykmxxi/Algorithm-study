package 위상정렬.음악프로그램;

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
	static ArrayList<Integer>[] adj;
	static int[] indeg;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		indeg = new int[N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y;

			for (int j = 1; j < size; j++) {
				y = Integer.parseInt(st.nextToken());
				adj[x].add(y);
				indeg[y]++;
				x = y;
			}
		}
	}

	static void pro() {
		Deque<Integer> que = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				que.add(i);
			}
		}

		ArrayList<Integer> answer = new ArrayList<>();

		while (!que.isEmpty()) {
			int x = que.poll();
			answer.add(x);

			for (int y : adj[x]) {
				indeg[y]--;
				if (indeg[y] == 0) {
					que.add(y);
				}
			}
		}

		if (answer.size() == N) {
			for (int singer : answer) {
				sb.append(singer).append('\n');
			}
		} else {
			sb.append(0);
		}
		System.out.println(sb);

	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
