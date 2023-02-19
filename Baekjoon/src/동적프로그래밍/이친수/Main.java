package 동적프로그래밍.이친수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static long[][] Dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void pro() {
		long answer = 0L;
		Dy = new long[N + 1][2];

		Dy[1][0] = 0L;
		Dy[1][1] = 1L;

		for (int i = 2; i <= N; i++) {
			Dy[i][0] = Dy[i - 1][0] + Dy[i - 1][1];
			Dy[i][1] = Dy[i - 1][0];
		}

		answer = Dy[N][0] + Dy[N][1];
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
