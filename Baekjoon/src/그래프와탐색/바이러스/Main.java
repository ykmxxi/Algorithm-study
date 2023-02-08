package 그래프와탐색.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;
	static ArrayList<Integer> group;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];
		visit = new boolean[N + 1];

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
	}

	static void dfs(int x) {
		visit[x] = true;

		for (int y : adj[x]) {
			if (visit[y]) {
				continue;
			}
			group.add(y);
			dfs(y);
		}
	}

	static void pro() {
		group = new ArrayList<>();
		int answer = 0;

		dfs(1);

		answer = group.size();
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
