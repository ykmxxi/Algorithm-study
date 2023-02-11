package 그래프와탐색.결혼식;

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

	static int N, M;
	static ArrayList<Integer>[] adj;
	static int[] dist;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		dist = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			adj[x].add(y);
			adj[y].add(x);
		}
	}

	static void bfs(int start) {
		for (int i = 1; i <= N; i++) {
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
		int answer = 0;
		// TODO: BFS로 거리 구하기
		bfs(1);

		// TODO: dist[i] <= 2 인 인덱스 값의 개수 구하기
		for (int i = 2; i <= N; i++) {
			if (dist[i] <= 2 && dist[i] >= 1) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
