package ch05dfs_bfs.미로탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int[][] adj, dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				adj[i][j] = input.charAt(j - 1) - '0';
			}
		}
	}

	static void bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<>();

		q.add(a);
		q.add(b);

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];

				if (nx < 1 || ny < 1 || nx > N || ny > M) { // 범위를 넘어가면
					continue;
				}
				if (adj[nx][ny] != 1) { // 1 이 아닌점 = 괴물이 존재 or 이미 방문한 점
					continue;
				}

				q.add(nx);
				q.add(ny);
				adj[nx][ny] = adj[x][y] + 1;
			}
		}
	}

	static void pro() {
		// (1, 1) 시작 (N, M) 까지의 최소 거리
		bfs(1, 1);

		System.out.println(adj[N][M]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
