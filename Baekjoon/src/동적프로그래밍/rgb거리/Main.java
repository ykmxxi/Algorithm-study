package 동적프로그래밍.rgb거리;

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

		A = new int[N + 1][3];
		Dy = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			A[i][0] = r;
			A[i][1] = g;
			A[i][2] = b;
		}
	}

	static void pro() {
		int answer = 0;

		// 초기값
		for (int i = 0; i < 3; i++) {
			Dy[1][i] = A[1][i];
		}

		for (int i = 2; i <= N; i++) {
			Dy[i][0] = Math.min(Dy[i - 1][1], Dy[i - 1][2]) + A[i][0];
			Dy[i][1] = Math.min(Dy[i - 1][0], Dy[i - 1][2]) + A[i][1];
			Dy[i][2] = Math.min(Dy[i - 1][0], Dy[i - 1][1]) + A[i][2];
		}

		answer = Dy[N][0];
		for (int i = 1; i < 3; i++) {
			answer = Math.min(answer, Dy[N][i]);
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
