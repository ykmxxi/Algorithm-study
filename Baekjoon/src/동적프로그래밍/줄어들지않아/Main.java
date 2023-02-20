package 동적프로그래밍.줄어들지않아;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static long[][] Dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void preprocess() {
		Dy = new long[65][10];

		for (int i = 0; i < 10; i++) {
			Dy[1][i] = 1;
		}

		for (int i = 2; i <= 64; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					Dy[i][j] += Dy[i - 1][k];
				}
			}
		}
	}

	static void pro() {
		long answer = 0;

		for (int i = 0; i < 10; i++) {
			answer += Dy[N][i];
		}

		sb.append(answer).append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		preprocess();

		while (T-- > 0) {
			input();
			pro();
		}
		System.out.println(sb);
	}
}
