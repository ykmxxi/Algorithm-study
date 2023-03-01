package 류호석코테1회.인내의도미노장인호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, R, score;
	static int[][] A, backup;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N + 1][M + 1];
		backup = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				backup[i][j] = A[i][j];
			}
		}
	}

	// x행 y열에 있는 도미노를 dir 방향으로 밀어버리는 함수
	static void attack(int x, int y, char dir) {
		if (A[x][y] == 0) { // 이미 넘어진 도미노는 무시
			return;
		}

		int dx = 0, dy = 0;
		if (dir == 'E') {
			dy = 1;
		} else if (dir == 'W') {
			dy = -1;
		} else if (dir == 'S') {
			dx = 1;
		} else {
			dx = -1;
		}

		int cnt = A[x][y]; // 연쇄적으로 넘어질 도미노의 개수
		while (x >= 1 && x <= N && y >= 1 && y <= M && cnt >= 1) {
			if (A[x][y] != 0) {
				score++;
			}

			cnt = Math.max(cnt - 1, A[x][y] - 1); // 한개를 넘어뜨렸으니 cnt - 1, 현재 위치의 도미노를 넘어뜨렸을 때 연쇄적으로 넘어질 도미노의 개수
			A[x][y] = 0; // 넘어 뜨리기

			// 다음칸으로 이동
			x += dx;
			y += dy;
		}
	}

	static void pro() throws IOException {
		for (int i = 1; i <= R; i++) {
			int x, y;
			String dir;

			// 공격
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			dir = st.nextToken();

			attack(x, y, dir.charAt(0));

			// 수비
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			A[x][y] = backup[x][y];
		}

		sb.append(score).append('\n');
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (A[i][j] == 0) {
					sb.append("F ");
				} else {
					sb.append("S ");
				}
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}

