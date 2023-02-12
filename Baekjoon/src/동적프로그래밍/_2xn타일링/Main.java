package 동적프로그래밍._2xn타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n;
	static int[] Dy;

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
	}

	static void pro() {
		Dy = new int[1005];

		Dy[1] = 1;
		Dy[2] = 2;
		Dy[3] = 3;

		for (int i = 4; i <= n; i++) {
			Dy[i] = (Dy[i - 1] + Dy[i - 2]) % 10007;
		}

		System.out.println(Dy[n]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
