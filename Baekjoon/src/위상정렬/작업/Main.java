package 위상정렬.작업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] indeg, T, T_done;
	static ArrayList<Integer>[] adj;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		indeg = new int[N + 1];
		T = new int[N + 1];
		T_done = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			T[i] = Integer.parseInt(st.nextToken());
			indeg[i] = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				adj[Integer.parseInt(st.nextToken())].add(i);
			}
		}
	}

	static void pro() {
		Deque<Integer> que = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				que.add(i);
				T_done[i] = T[i];
			}
		}

		while (!que.isEmpty()) {
			int x = que.poll();

			for (int y : adj[x]) {
				indeg[y]--;

				if (indeg[y] == 0) {
					que.add(y);
				}
				T_done[y] = Math.max(T_done[y], T_done[x] + T[y]);
			}
		}

		int answer = T_done[1];

		for (int i = 2; i <= N; i++) {
			answer = Math.max(answer, T_done[i]);
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
