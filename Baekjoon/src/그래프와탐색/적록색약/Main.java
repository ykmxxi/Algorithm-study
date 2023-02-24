package 그래프와탐색.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static String[] A;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();
		}
	}

	static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			if (visit[nx][ny]) {
				continue;
			}
			if (A[x].charAt(y) != A[nx].charAt(ny)) {
				continue;
			}

			dfs(nx, ny);
		}
	}

	static void pro() {
		// 초기화
		int cnt = 0;
		visit = new boolean[N][N];

		// 적록색약이 아닌 사람
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt).append(' ');

		// 적록색약인 사람
		// 초기화, G -> R
		cnt = 0;
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			A[i] = A[i].replace("G", "R");
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
