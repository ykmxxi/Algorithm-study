package d2.숫자배열회전;

/*
	# 1961. 숫자 배열 회전

	- N x N 행렬이 주어질 때 90, 180, 270 회전한 모양을 출력
	- 3 <= N <= 7

	## 입력
	- 첫째 줄: 테케 개수 T
	- 각 테케 첫 줄: N
	- 다음 N개의 줄에 걸쳐 행렬이 주어짐

	## 출력
	- #t
	- 1열: 90도 회전, 2열: 180도 회전, 3열: 270도 회전
 */

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static int[][] A;
	static String[][] ans;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void rotate() {
		int row = A[0].length;
		int col = A.length;

		int[][] clone = new int[N][N];
		for (int i = 0; i < N; i++) {
			clone[i] = A[i].clone();
		}

		A = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				A[i][j] = clone[row - 1 - j][i];
			}
		}
	}

	static void pro(int tc) {
		ans = new String[N][3];

		// 3차례 회전을 한다
		for (int i = 0; i < 3; i++) {
			rotate();
			for (int j = 0; j < N; j++) {
				StringBuilder builder = new StringBuilder();
				for (int num : A[j]) {
					builder.append(num);
				}

				ans[j][i] = builder.toString();
			}
		}

		sb.append('#').append(tc).append('\n');
		for (String[] arr : ans) {
			for (String str : arr) {
				sb.append(str).append(' ');
			}
			sb.append('\n');
		}
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			input();
			pro(tc);
		}

		System.out.print(sb);
	}

}
