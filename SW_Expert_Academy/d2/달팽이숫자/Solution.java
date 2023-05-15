package d2.달팽이숫자;

/*
	# 1954 달팽이 숫자

	- 1 부터 N*N 까지의 숫자가 시계방향으로 이루어짐
	- 정수 N을 입력 받아 N크기의 달팽이를 출력

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] A, dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동 남 서 북

	static void pro(int tc) {
		A = new int[N][N];

		int row = 0;
		int col = 0;
		int k = 0;

		for (int i = 1; i <= N * N; i++) {
			A[row][col] = i;

			int nx = row + dir[k % 4][0];
			int ny = col + dir[k % 4][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N || A[nx][ny] != 0) {
				k++;
			}

			row += dir[k % 4][0];
			col += dir[k % 4][1];
		}

		sb.append('#').append(tc).append('\n');
		for (int[] arr : A) {
			for (int num : arr) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
		}
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			pro(i);
		}

		System.out.print(sb);
	}
}
