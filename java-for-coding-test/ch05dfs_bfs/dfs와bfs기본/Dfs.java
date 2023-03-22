package ch05dfs_bfs.dfs와bfs기본;

import java.util.ArrayList;

public class Dfs {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited = new boolean[9];
	static ArrayList<Integer>[] adj;

	static void dfs(int x) {
		visited[x] = true; // 방문 처리
		sb.append(x).append(" -> ");

		for (int y : adj[x]) {
			if (visited[y]) {
				continue;
			}

			dfs(y);
		}
	}

	public static void main(String[] args) {
		adj = new ArrayList[9];

		for (int i = 0; i < 9; i++) {
			adj[i] = new ArrayList<>();
		}

		adj[1].add(2);
		adj[1].add(3);
		adj[1].add(8);

		adj[2].add(1);
		adj[2].add(7);

		adj[3].add(4);
		adj[3].add(5);

		adj[4].add(3);
		adj[4].add(5);

		adj[5].add(3);
		adj[5].add(4);

		adj[6].add(7);

		adj[7].add(6);
		adj[7].add(8);

		adj[8].add(1);
		adj[8].add(7);

		dfs(1);
		System.out.println(sb);
	}
}
