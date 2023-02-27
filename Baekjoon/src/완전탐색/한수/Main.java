package 완전탐색.한수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP 풀이

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static int[] Dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static boolean check(int num) {
		if (num == 1000) {
			return false;
		}
		// 3 자리
		if (num % 10 - (num / 10) % 10 == (num / 10) % 10 - (num / 100) % 10) {
			return true;
		}

		return false;
	}

	static void preprocess() {
		// 초기값 설정
		Dy = new int[1001];
		for (int i = 1; i <= 99; i++) {
			Dy[i] = i;
		}

		for (int i = 100; i <= 1000; i++) {
			if (check(i)) {
				Dy[i] = Dy[i - 1] + 1;
			} else {
				Dy[i] = Dy[i - 1];
			}
		}
	}

	static void pro() {
		preprocess();
		System.out.println(Dy[N]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}

