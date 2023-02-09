package 그래프와탐색.촌수계산;

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

	static int n, m, from, to;
	static ArrayList<Integer>[] adj;
	static int[] dist;

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine(), " ");
		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
			adj[y].add(x);
		}
		dist = new int[n + 1];
	}

	static void bfs(int start) {
		for (int i = 1; i <= n; i++) {
			dist[i] = -1;
		}
		Queue<Integer> que = new LinkedList<>();

		que.add(start);
		dist[start] = 0;

		while (!que.isEmpty()) {
			int x = que.poll();

			for (int y : adj[x]) {
				if (dist[y] != -1) {
					continue;
				}
				que.add(y);
				dist[y] = dist[x] + 1;
			}
		}
	}

	static void pro() {
		bfs(from);
		System.out.println(dist[to]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
