package 완전탐색.한수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 완전 탐색
public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static boolean check(int num) {
		if (num < 100) {
			return true;
		}

		if (num < 1000) {
			int a1, a2, a3;
			a1 = num % 10;
			a2 = (num / 10) % 10;
			a3 = (num / 100) % 10;

			return a3 - a2 == a2 - a1;
		}

		return false;
	}

	static void pro() {
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			if (check(i)) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
