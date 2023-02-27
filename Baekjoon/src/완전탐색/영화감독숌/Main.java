package 완전탐색.영화감독숌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static boolean check(int num) {
		int cnt = 0;

		while (num > 0) {
			if (num % 10 == 6) {
				cnt++;
			} else {
				cnt = 0;
			}
			if (cnt == 3) {
				return true;
			}
			num /= 10;
		}

		return false;
	}

	static void pro() {
		int answer = 0;
		int num = 666;

		while (N > 0) {
			if (check(num)) {
				answer = num;
				N--;
			}
			num++;
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
