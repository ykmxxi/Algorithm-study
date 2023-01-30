package 두포인터.좋다;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

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

	static boolean isGood(int target_idx) { // 두 수로 target 값이 표현되는가?
		int L = 1, R = N; // L 을 최소값, R 을 최대값으로 초기 설정
		int target = A[target_idx];

		while (L < R) {
			if (L == target_idx) {
				L++;
			} else if (R == target_idx) {
				R--;
			} else {
				if (A[L] + A[R] == target) {
					return true;
				}
				if (A[L] + A[R] > target) {
					R--; // 최대값을 더 작은 값으로 갱신
				}
				if (A[L] + A[R] < target) {
					L++; // 최소값을 더 큰 값으로 갱신
				}
			}
		}
		return false;
	}

	static void pro() {
		// 배열 정렬
		Arrays.sort(A, 1, N + 1);

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (isGood(i)) { // i 번째 원소가 GOOD 인지 확인
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
