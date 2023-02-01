package 이분탐색.이상한술집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[] A;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
	}

	static boolean determination(long amount) {
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			cnt += A[i] / amount;
		}
		return cnt >= K;
	}

	static void pro() {
		long L = 1L, R = Integer.MAX_VALUE, answer = 0L;

		while (L <= R) {
			long mid = (L + R) / 2;
			if (determination(mid)) {
				answer = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
