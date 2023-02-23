package 패캠제작문제1.소수최소공배수;

/*
	길이가 N인 수열 A에서 소수들을 골라 최소공배수를 구하는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N; // 1 ~ 10_000
	static long[] A; // 2 ~ 1_000_000

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new long[N + 1];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
	}

	static boolean isPrime(long x) { // 소수 확인
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	static long GCD(long a, long b) { // 최대 공약수
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}

	static long LCM(long a, long b) {
		return (a * b) / GCD(a, b);
	}

	static void pro() {
		long answer = 1L; // 답이 2^63 미만, 소수가 없는 경우 -1을 출력

		// 소수 구하기: 소수는 1과 자기 자신만

		for (int i = 1; i <= N; i++) {
			if (isPrime(A[i])) {
				answer = LCM(answer, A[i]);
			}
		}

		if (answer == 1) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
