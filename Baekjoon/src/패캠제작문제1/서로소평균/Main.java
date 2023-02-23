package 패캠제작문제1.서로소평균;

/*
	길이가 N인 수열 A에서 X와 서로소인 수들을 골라 평균을 구하는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, X; // sum의 최대값: 5 * 10^5 * 10^6 (long)
	static int[] A;
	static boolean[] B;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		X = Integer.parseInt(br.readLine());
	}

	static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}

	static void pro() {
		// X와 서로소 구하기: 1 제외 나누어 떨어지는 공약수가 없는 경우가 서로소
		long sum = 0L;
		long cnt = 0L;

		for (int i = 1; i <= N; i++) {
			if (GCD(X, A[i]) == 1) { // 최대 공약수가 1이면 서로소
				sum += A[i];
				cnt++;
			}
		}

		// 평균 구하기
		System.out.printf("%.6f", (double)sum / cnt);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
