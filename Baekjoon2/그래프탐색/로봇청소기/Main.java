package 그래프탐색.로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, r, c, d, answer;
	static int[][] A, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int rotate(int curD) {
		if (curD == 0) {
			return 3;
		}
		return curD - 1;
	}

	static void dfs(int x, int y, int d) {
		A[x][y] = 2; // 청소

		// 현재 칸의 주변 4칸 탐색
		for (int k = 0; k < 4; k++) {
			d = rotate(d);
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];


			// 청소할 칸이 있으면
			if (nx >= 0 && ny >= 0 && nx < N && ny < M && A[nx][ny] == 0) {
				answer++;
				dfs(nx, ny, d);
				return;
			}
		}

		int back = (d + 2) % 4; // 뒤 칸, 서쪽을 바라보고 있는 경우 뒤 칸은 동쪽을 바라보고 있을 때 한 칸 전진한 것과 같음
		int bx = x + dir[back][0];
		int by = y + dir[back][1];

		if (bx >= 0 && by >= 0 && bx < N && by < M && A[bx][by] != 1) {
			dfs(bx, by, d); // 후진한 곳이 벽이 아니면 다시 탐색
		}
		// 후진한 곳이 벽이면 이곳에 도달해 종료
	}

	static void pro() {
		answer = 1; // 첫 칸은 무조건 비어있으니 청소 가능

		dfs(r, c, d);
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
