package 동적프로그래밍.오르막수;

/* https://www.acmicpc.net/problem/11057
	오르막 수는 수의 자리가 오름차순을 이루는 수
	인접한 수가 같아도 오름차순으로 생각
	오르막 수: 2234, 3678, 11119
	오르막 수X: 2232, 3676, 91111
	수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 문제, 수는 0으로 시작할 수 없음
	N인 오르막 수의 개수를 10,007로 나눈 나머지
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static final int MOD = 10007;
	static int N;
	static int[][] Dy; // [i][j]: i 길이일 때, 시작하는 숫자가 j인 경우의 수

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine()); // N 1 이상 1,000 이하
	}

	static void pro() {
		Dy = new int[1005][10];

		for (int i = 0; i <= 9; i++) {
			Dy[1][i] = 1;
		}

		for (int length = 2; length <= 1000; length++) {
			for (int start = 0; start <= 9; start++) {
				for (int k = start; k <= 9; k++) {
					Dy[length][start] += Dy[length - 1][k];
					Dy[length][start] %= MOD;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i <= 9; i++) {
			answer += Dy[N][i];
			answer %= MOD;
		}

		System.out.println(answer);

	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
