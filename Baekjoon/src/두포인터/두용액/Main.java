package 두포인터.두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] A;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		// 배열 정렬
		Arrays.sort(A, 1, N + 1);

		int best_sum = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0;
		int L = 1, R = N; // 초기 L, R 두포인터 설정

		while (L < R) { // L == R 인 경우 용액이 한 개 뿐이므로 L < R 까지만 반복
			int sum = A[L] + A[R];

			if (Math.abs(sum) < best_sum) { // 정답 갱신
				best_sum = Math.abs(sum);
				v1 = A[L];
				v2 = A[R];
			}

			if (sum > 0) { // 최소 + 최대 > 0 이면 최대값 삭제
				R--;
			} else { // 최소 + 최대 <= 0 이면 최소 최소값 삭제
				L++;
			}
		}

		sb.append(v1).append(' ').append(v2);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
