package 이분탐색.용돈관리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int[] A;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
	}

	static boolean determination(int K) {
		int sum = 0, cnt = 1;
		for (int i = 1; i <= N; i++) {
			if (sum + A[i] > K) {
				cnt++;
				sum = A[i];
			} else {
				sum += A[i];
			}
		}
		return cnt <= M;
	}

	static void pro() {
		int L = A[1];
		for (int i = 2; i <= N; i++) {
			L = Math.max(L, A[i]);
		}
		int R = 1000000000;
		int answer = 0;

		while (L <= R) {
			int mid = (L + R) / 2;
			if (determination(mid)) {
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
