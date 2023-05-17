package d2.파스칼의삼각형;

/*
	2005. 파스칼의 삼각형

	- 크기가 N인 파스칼의 삼각형을 만들어야 한다
	1. 첫 번째 줄은 항상 숫자 1
	2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] A;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N][N];
	}

	static void pro(int tc) {
		sb.append('#').append(tc).append('\n');

		// 1. 첫 번째 줄은 항상 숫자 1
		A[0][0] = 1;
		sb.append(A[0][0]).append('\n');

		// 2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) { // 각 줄의 첫 번째 요소이면 -> 자신의 오른쪽 위만
					A[i][j] += A[i - 1][j];
					sb.append(A[i][j]).append(' ');
					continue;
				}
				if (j == i) { // 각 줄의 마지막 요소이면 -> 자신의 왼쪽 위만
					A[i][j] += A[i - 1][j - 1];
					sb.append(A[i][j]).append(' ');
					continue;
				}
				// 자신의 왼쪽과 오른쪽 위의 숫자의 합
				A[i][j] += A[i - 1][j - 1] + A[i - 1][j];
				sb.append(A[i][j]).append(' ');
			}
			sb.append('\n');
		}
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			input();
			pro(i);
		}

		System.out.print(sb);
	}
}
