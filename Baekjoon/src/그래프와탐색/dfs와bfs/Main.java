package 그래프와탐색.dfs와bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접 리스트 사용
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, V;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
			adj[y].add(x);
		}

		// 작은 번호의 정점부터 방문하기 위해 초기 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
	}

	static void dfs(int x) {
		visit[x] = true;
		sb.append(x).append(' ');
		for (int y : adj[x]) {
			if (visit[y]) {
				continue;
			}
			dfs(y);
		}
	}

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();

		que.add(start);
		visit[start] = true;

		while (!que.isEmpty()) {
			int x = que.poll();

			sb.append(x).append(' ');
			for (int y : adj[x]) {
				if (visit[y]) {
					continue;
				}
				que.add(y);
				visit[y] = true;
			}
		}
	}

	static void pro() {
		visit = new boolean[N + 1];
		dfs(V);

		sb.append('\n');
		for (int i = 1; i <= N; i++) {
			visit[i] = false;
		}

		bfs(V);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
