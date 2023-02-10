package 그래프와탐색.케빈베이컨6단계법칙;

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
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
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
		dist = new int[N + 1];
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

	static int summation(int index) {
		int result = 0;
		for (int i = 1; i <= N; i++) {
			result += dist[i];
		}
		return result;
	}

	static void pro() {
		int answer = 0;
		int sum = Integer.MAX_VALUE;
		// 1 ~ N 까지 시작점으로 설정해 각각 bfs
		for (int i = 1; i <= N; i++) {
			bfs(i);
			// 정답 찾기

			int curSum = summation(i);
			if (sum > curSum) {
				sum = curSum;
				answer = i;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
