package 완전탐색.분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static int decomposition(int k) {
		int result = k;

		while (k > 0) {
			result = result + k % 10;
			k = k / 10;
		}

		return result;
	}

	static void pro() {
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (N == decomposition(i)) { // 0 부터 분해합이 N과 같아지는 제일 작은 수 찾기
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
