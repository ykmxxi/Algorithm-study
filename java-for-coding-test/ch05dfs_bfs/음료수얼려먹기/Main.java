package ch05dfs_bfs.음료수얼려먹기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int[][] adj;
	static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static boolean[][] visited;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				adj[i][j] = Integer.parseInt(input.substring(j - 1, j));
			}
		}
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx < 1 || ny < 1 || nx > N || ny > M) { // 범위를 벗어나거나
				continue;
			}
			if (visited[nx][ny] || adj[nx][ny] == 1) { // 이미 방문 or 막혀 있으면
				continue;
			}

			dfs(nx, ny);
		}
	}

	static void pro() {
		// 초기화
		int answer = 0;
		visited = new boolean[N + 1][M + 1];

		// dfs
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (visited[i][j] || adj[i][j] == 1) { // 이미 방문 or 막혀 있으면
					continue;
				}

				dfs(i, j);
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
