package 두포인터.부분합;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, S;
	static int[] A;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		A = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		int R = 0;
		int sum = 0;
		int answer = N + 1;

		for (int L = 1; L <= N; L++) {
			// L - 1을 구간에서 제외
			sum -= A[L - 1];

			// R을 옮길 수 있을 때 까지 옮기기
			while (R + 1 <= N && sum < S) {
				R++;
				sum += A[R];
			}

			// [L, L + 1, ..., R] 의 합, 즉 sum >= S 조건을 만족하면 정답 갱신
			if (sum >= S) {
				answer = Math.min(answer, R - L + 1);
			}
		}
		// answer 값을 보고 불가능 판단
		if (answer == N + 1) {
			answer = 0;
		}
		sb.append(answer);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
