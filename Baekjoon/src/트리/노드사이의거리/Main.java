package 트리.노드사이의거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static ArrayList<Edge>[] adj; // adj[i] = {연결된 노드, 거리}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			adj[x].add(new Edge(y, dist));
			adj[y].add(new Edge(x, dist));
		}
	}

	static void dfs(int x, int y, int prev, int dist) {
		if (x == y) {
			sb.append(dist).append('\n');
			return;
		}

		for (Edge e : adj[x]) {
			if (e.vertex == prev) {
				continue;
			}
			dfs(e.vertex, y, x, dist + e.distance);
		}
	}

	static void pro() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		dfs(x, y, -1, 0);
	}

	public static void main(String[] args) throws IOException {
		input();
		for (int i = 1; i <= M; i++) {
			pro();
		}
		System.out.println(sb);
	}

	static class Edge {
		int vertex;
		int distance;

		Edge(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}
}
