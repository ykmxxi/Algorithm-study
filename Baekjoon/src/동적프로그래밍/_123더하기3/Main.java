package 동적프로그래밍._123더하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, MOD = 1000000009;
	static int[] Dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void preprocess() {
		Dy = new int[1000005];

		Dy[1] = 1;
		Dy[2] = 2;
		Dy[3] = 4;

		for (int i = 4; i <= 1000000; i++) {
			Dy[i] = Dy[i - 1];
			Dy[i] += Dy[i - 2];
			Dy[i] %= MOD;
			Dy[i] += Dy[i - 3];
			Dy[i] %= MOD;
		}
	}

	static void pro() {
		sb.append(Dy[N]).append('\n');
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
