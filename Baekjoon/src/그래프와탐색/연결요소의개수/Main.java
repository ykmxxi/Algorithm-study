package 그래프와탐색.연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, u, v; // 정점의 개수, 간선의 개수, 간선의 양 끝점
	static ArrayList<Integer>[] A;
	static boolean[] visit;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			A[u].add(v);
			A[v].add(u);
		}
		visit = new boolean[N + 1];
	}

	/*
	static void dfs(int u) {
		visit[u] = true;

		for (int v : A[u]) {
			if (visit[v]) {
				continue;
			}
			dfs(v);
		}

	}
	 */

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visit[start] = true;

		while (!que.isEmpty()) {
			int u = que.poll();

			for (int v : A[u]) {
				if (visit[v]) {
					continue;
				}

				que.add(v);
				visit[v] = true;
			}
		}
	}

	static void pro() {
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (visit[i]) {
				continue;
			}
			// dfs(i);
			bfs(i);
			answer++;
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
