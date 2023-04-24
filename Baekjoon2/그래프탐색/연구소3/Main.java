package 그래프탐색.연구소3;

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

	static int N, M, min = Integer.MAX_VALUE, originCnt;
	static int[][] adj, dist, visited, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static ArrayList<Virus> info;

	static class Virus {
		int x;
		int y;

		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new int[N][N];
		info = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
				if (adj[i][j] == 2) {
					info.add(new Virus(i, j));
				}
				if (adj[i][j] == 0) {
					originCnt++;
				}
			}
		}
	}

	static void bfs() {
		int cnt = 0;
		Queue<Virus> q = new LinkedList<>();
		dist = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (adj[i][j] == 3) {
					q.add(new Virus(i, j));
					visited[i][j] = 1;
				}
			}
		}

		while (!q.isEmpty()) {
			Virus v = q.poll();
			int x = v.x;
			int y = v.y;

			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || adj[nx][ny] == 1) {
					continue;
				}

				if (visited[nx][ny] == 0) { // 아직 방문하지 않았으면
					dist[nx][ny] = dist[x][y] + 1;
					q.add(new Virus(nx, ny));
					visited[nx][ny] = 1;

					if (adj[nx][ny] == 0) {
						cnt++;
					}

					if (cnt == originCnt) {
						min = Math.min(min, dist[nx][ny]);
					}
				}
			}
		}
	}

	static void dfs(int depth, int start) {
		if (depth == M) {
			bfs();
		} else {
			for (int cand = start; cand < info.size(); cand++) {
				Virus v = info.get(cand);

				adj[v.x][v.y] = 3;
				dfs(depth + 1, cand + 1);
				adj[v.x][v.y] = 2;
			}
		}

	}

	static void pro() {
		if (originCnt == 0) {
			System.out.println(0);
		} else {
			dfs(0, 0);

			if (min == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(min);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
