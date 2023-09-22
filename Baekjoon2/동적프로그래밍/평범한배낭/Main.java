package 동적프로그래밍.평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K;
	static int[][] A, Dy;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1][2]; // weight, value
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A[i][0] = Integer.parseInt(st.nextToken());
			A[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		Dy = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				Dy[i][j] = Dy[i - 1][j];
				if (j - A[i][0] >= 0) {
					Dy[i][j] = Math.max(Dy[i][j], Dy[i - 1][j - A[i][0]] + A[i][1]);
				}
			}
		}

		System.out.println(Dy[N][K]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
