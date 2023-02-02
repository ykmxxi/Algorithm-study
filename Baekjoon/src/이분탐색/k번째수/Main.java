package 이분탐색.k번째수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, k;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
	}

	// candidate 이하의 숫자가 K개 이상인가?
	static boolean determination(long candidate) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			// sum += Math.min(N, candidate / i); // 최적의 풀이
			// 행 별로 최대값은 N * 행의 번호 <= candidate 이면 그 행은 모두 candidate 보다 작다
			if ((long)N * i <= candidate) {
				sum += N;
			} else {
				sum += candidate / i; // candidate < i * N 이면, candidate / i 개의 숫자가 candidate보다 작다.
			}
		}
		return sum >= k;
	}

	static void pro() {
		long L = 1, R = (long)N * N, answer = 0;

		while (L <= R) {
			long mid = (L + R) / 2;
			if (determination(mid)) { // K개 이상이니까 값을 줄인다
				answer = mid;
				R = mid - 1;
			} else { // K개 미만이니까 값을 키운다
				L = mid + 1;
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
