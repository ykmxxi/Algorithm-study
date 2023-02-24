package 그래프와탐색.음식물피하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, K, size;
	static int[][] A;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1][M + 1];
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			A[r][c] = 1;
		}

		visit = new boolean[N + 1][M + 1];
	}

	static void dfs(int x, int y) {
		size++;
		visit[x][y] = true;

		for (int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx < 1 || ny < 1 || nx > N || ny > M) {
				continue;
			}
			if (A[nx][ny] == 0) {
				continue;
			}
			if (visit[nx][ny]) {
				continue;
			}

			dfs(nx, ny);
		}
	}

	static void pro() {
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!visit[i][j] && A[i][j] == 1) {
					size = 0;
					dfs(i, j);
					answer = Math.max(answer, size);
				}
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
