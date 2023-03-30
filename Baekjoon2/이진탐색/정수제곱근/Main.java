package 이진탐색.정수제곱근;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static Long N;

	static void input() throws IOException {
		N = Long.parseLong(br.readLine());
	}

	static void pro() {
		long L = 0L;
		long R = N;
		long answer = 0L;

		while (L <= R) {
			long mid = (L + R) / 2;
			long result = (long)Math.pow(mid, 2);

			if (result < N) {
				L = mid + 1;
			} else {
				R = mid - 1;
				answer = mid;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
