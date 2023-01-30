package 두포인터.수들의합2;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] A;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		int R = 0;
		int answer = 0;
		int sum = 0;

		for (int L = 1; L <= N; L++) {
			// L이 옮겨지면서 이전 값인 L - 1을 구간에서 제외
			sum -= A[L - 1];

			while (R + 1 <= N && sum < M) {
				R++;
				sum += A[R];
			}

			// 만약 부분수열의 합이 M을 만족하면 경우의 수 +1
			if (sum == M) {
				answer++;
			}
		}

		sb.append(answer);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
