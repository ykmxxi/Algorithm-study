package 그래프와탐색.순열사이클;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, cnt;
	static int[] A;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = i;
			adj[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int x = A[i];
			int y = Integer.parseInt(st.nextToken());

			adj[x].add(y);
		}
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;

		while (!q.isEmpty()) {
			int x = q.poll();

			for (int y : adj[x]) {
				if (y == start) {
					cnt++;
					return;
				}
				if (visit[y]) {
					continue;
				}
				q.add(y);
				visit[y] = true;
			}
		}
	}

	static void pro() {
		visit = new boolean[N + 1];
		cnt = 0;

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				bfs(i);
			}
		}
		sb.append(cnt).append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			input();
			pro();
		}
		System.out.println(sb);
	}
}
