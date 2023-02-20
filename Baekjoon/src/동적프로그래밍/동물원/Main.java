package 동적프로그래밍.동물원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N, MOD = 9901;
	static int[][] Dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		Dy = new int[N + 1][3];
	}

	static void pro() {
		Dy[1][0] = 1;
		Dy[1][1] = 1;
		Dy[1][2] = 1;

		for (int i = 2; i <= N; i++) {
			Dy[i][0] = Dy[i - 1][0] + Dy[i - 1][1] + Dy[i - 1][2];
			Dy[i][1] = Dy[i - 1][0] + Dy[i - 1][2];
			Dy[i][2] = Dy[i - 1][0] + Dy[i - 1][1];

			for (int j = 0; j < 3; j++) {
				Dy[i][j] %= MOD;
			}
		}

		int answer = (Dy[N][0] + Dy[N][1] + Dy[N][2]) % MOD;
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
