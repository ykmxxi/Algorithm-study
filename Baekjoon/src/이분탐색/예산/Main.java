package 이분탐색.예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M; // 지방의 수, 총 예산
	static int[] A;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
	}

	static boolean isBigger() { // 총액 보다 큰가?
		int total = 0;
		for (int i = 1; i <= N; i++) {
			total += A[i];
		}

		return total > M;
	}

	static boolean determination(int max) {
		int total = 0;

		for (int i = 1; i <= N; i++) {
			total += Math.min(A[i], max);
		}

		return total <= M;
	}

	static void pro() {
		Arrays.sort(A, 1, N + 1);

		int L = 1;
		int R = 1000000000;
		int answer = 0;

		while (L <= R) {
			int mid = (L + R) / 2;

			if (!isBigger()) {
				answer = A[N];
				break;
			}

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
