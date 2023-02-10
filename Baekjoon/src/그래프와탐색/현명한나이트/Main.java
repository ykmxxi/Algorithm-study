package 그래프와탐색.현명한나이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, X, Y;
	static int[][] dist;
	static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		dist = new int[N + 1][N + 1];
	}

	static void bfs() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dist[i][j] = 0;
			}
		}
		Queue<Integer> que = new LinkedList<>();
		que.add(X);
		que.add(Y);

		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();

			for (int k = 0; k < 8; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				if (nx < 1 || ny < 1 || nx > N || ny > N) {
					continue;
				}
				if (dist[nx][ny] != 0) {
					continue;
				}

				que.add(nx);
				que.add(ny);
				dist[nx][ny] = dist[x][y] + 1;
			}
		}
	}

	static void pro() throws IOException {
		bfs();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			sb.append(dist[dx][dy]).append(' ');
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
