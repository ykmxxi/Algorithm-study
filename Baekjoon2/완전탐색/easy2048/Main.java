package 완전탐색.easy2048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, max;
	static int[] selected;
	static int[][] A, B, visit;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 위, 오른쪽, 아래, 왼쪽

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void move(int x, int y, int d) {
		if (B[x][y] == 0) {
			return;
		}

		while (true) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				return;
			}
			if (visit[nx][ny] == 1) {
				return;
			}

			if (B[nx][ny] == B[x][y]) { // 같으면 합치기
				visit[nx][ny] = 1;
				B[nx][ny] *= 2;
				B[x][y] = 0;
				return;
			} else if (B[nx][ny] != 0) { // 같지 않고 비어있지 않으면 옮길 수 없으니 종료
				return;
			}

			// 같지 않고 비어 있으니 옮기기, (x, y) -> (nx, ny)
			B[nx][ny] = B[x][y];
			B[x][y] = 0;
			x = nx;
			y = ny;
		}
	}

	static int calculate() {
		int answer = 0;
		B = new int[N][N];

		for (int i = 0; i < N; i++) {
			B[i] = A[i].clone();
		}

		for (int idx = 0; idx < selected.length; idx++) {
			visit = new int[N][N];

			if (selected[idx] == 0) { // 위
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						move(i, j, selected[idx]);
					}
				}
			} else if (selected[idx] == 1) { // 오른쪽
				for (int i = N - 1; i >= 0; i--) {
					for (int j = 0; j < N; j++) {
						move(j, i, selected[idx]);
					}
				}

			} else if (selected[idx] == 2) { // 아래
				for (int i = N - 1; i >= 0; i--) {
					for (int j = 0; j < N; j++) {
						move(i, j, selected[idx]);
					}
				}
			} else { // 왼쪽
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						move(j, i, selected[idx]);
					}
				}
			}
		}

		for (int[] row : B) {
			for (int num : row) {
				answer = Math.max(answer, num);
			}
		}
		return answer;
	}

	static void rec_func(int k) {
		if (k == 5) {
			// 값 계산
			max = Math.max(max, calculate());
		} else {
			for (int cand = 0; cand < 4; cand++) {
				selected[k] = cand;
				rec_func(k + 1);
				selected[k] = 0;
			}
		}

	}

	static void pro() {
		// 1024 가지의 경우에 대해 탐색하면서 최대값을 갱신
		selected = new int[5];

		rec_func(0);

		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
