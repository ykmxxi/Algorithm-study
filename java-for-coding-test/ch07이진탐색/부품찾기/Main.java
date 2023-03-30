package ch07이진탐색.부품찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static int[] A, B;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());

		B = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
	}

	static boolean binarySearch(int target) {
		int L = 0;
		int R = N - 1;

		while (L <= R) {
			int mid = (L + R) / 2;

			if (A[mid] == target) {
				return true;
			}

			if (A[mid] <= target) {
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}

		return false;
	}

	static void pro() {
		// B 배열을 순회하면서, B[i] 가 기준값이 되어 A 배열에 존재하는지 탐색
		Arrays.sort(A);

		for (int i = 0; i < M; i++) {
			if (binarySearch(B[i])) {
				sb.append("yes").append(' ');
			} else {
				sb.append("no").append(' ');
			}
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
