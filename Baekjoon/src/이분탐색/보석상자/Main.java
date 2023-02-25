package 이분탐색.보석상자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, MAX = 0;
	static long sum = 0L;
	static int[] A;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[M];
		for (int i = 0; i < M; i++) {
			A[i] = Integer.parseInt(br.readLine());
			MAX = Math.max(MAX, A[i]);
			sum += A[i];
		}
	}

	static boolean possible(long K) {
		int sum = 0;
		for (int  i = 0; i < M; i++) {
			sum += A[i] / K;
			if (A[i] % K != 0) {
				sum++; // K 개 보다 적은 것을 나머지 사람에게 나눠줌
			}
		}

		return sum <= N;
	}

	static void pro() {
		long answer = 0;
		long L = sum / N;
		long R = MAX;

		while (L <= R) {
			long mid = (L + R) / 2;

			if (possible(mid)) {
				answer = mid;
				R = mid - 1;
			} else {
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
