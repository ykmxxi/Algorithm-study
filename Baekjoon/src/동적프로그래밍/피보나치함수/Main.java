package 동적프로그래밍.피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] Dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void preprocess() {
		Dy = new int[41][2];

		Dy[0][0] = 1;
		Dy[0][1] = 0;
		Dy[1][0] = 0;
		Dy[1][1] = 1;

		for (int i = 2; i <= 40; i++) {
			Dy[i][0] = Dy[i - 1][0] + Dy[i - 2][0];
			Dy[i][1] = Dy[i - 1][1] + Dy[i - 2][1];
		}
	}

	static void pro() {
		sb.append(Dy[N][0]).append(' ').append(Dy[N][1]).append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		preprocess();

		while (T > 0) {
			T--;
			input();
			pro();
		}
		System.out.println(sb);
	}
}