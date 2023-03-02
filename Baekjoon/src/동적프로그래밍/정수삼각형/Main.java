package 동적프로그래밍.정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[][] A, Dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N + 1][N + 1];
		Dy = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= i; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() {
		int answer = 0;

		Dy[1][1] = A[1][1];

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1) {
					Dy[i][j] = Dy[i - 1][1] + A[i][j];
				} else if (j > 1 && j < i) {
					Dy[i][j] = Math.max(Dy[i - 1][j - 1], Dy[i - 1][j]) + A[i][j];
				} else {
					Dy[i][j] = Dy[i - 1][i - 1] + A[i][j];
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, Dy[N][i]);
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
