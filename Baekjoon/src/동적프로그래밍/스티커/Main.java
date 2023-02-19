package 동적프로그래밍.스티커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static int[][] A, Dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[3][N + 1];
		Dy = new int[3][N + 1];
		for (int i = 1; i <= 2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() {
		int answer = 0;

		Dy[1][1] = A[1][1];
		Dy[2][1] = A[2][1];

		for (int i = 2; i <= N; i++) {
			Dy[1][i] += Math.max(Dy[2][i - 1], Dy[2][i - 2]) + A[1][i];
			Dy[2][i] += Math.max(Dy[1][i - 1], Dy[1][i - 2]) + A[2][i];
		}

		answer = Math.max(Dy[1][N], Dy[2][N]);
		sb.append(answer).append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		while (T > 0) {
			T--;
			input();
			pro();
		}
		System.out.print(sb);
	}
}
