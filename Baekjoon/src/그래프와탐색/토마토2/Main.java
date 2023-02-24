package 그래프와탐색.토마토2;

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
	static int[][] dist;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");

			while (st.hasMoreTokens()) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		dist = new int[N][M];
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();

		// 시작점들 탐색, 거리 배열 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j] = -1;

				if (adj[i].get(j) == 1) {
					q.add(i);
					q.add(j);
					dist[i][j] = 0;
				}
			}
		}

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if (adj[nx].get(ny) == -1) {
					continue;
				}
				if (dist[nx][ny] != -1) {
					continue;
				}

				q.add(nx);
				q.add(ny);
				dist[nx][ny] = dist[x][y] + 1;
			}
		}

	}

	static void pro() {
		// Multi-source bfs
		int answer = 0;
		bfs();

		Loop1:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (adj[i].get(j) == -1) {
					continue;
				}
				if (dist[i][j] == -1) {
					answer = -1;
					break Loop1;
				}

				answer = Math.max(answer, dist[i][j]);
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
