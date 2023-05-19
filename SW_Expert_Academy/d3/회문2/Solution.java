package d3.회문2;


/*
	# 1216. 회문2

	- 100 x 100 평면 글자판에서 가로, 세로를 모두 보아 가장 긴 회문의 길이를 구하는 문제

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static char[][] A;
	static final int L = 100;

	public static boolean solve(int l) {
		for (int i = 0; i < L; i++) {
			for (int j = 0; j <= (L - l); j++) {
				if (solveRow(i, j, l) || solveColumn(j, i, l))
					return true;
			}
		}

		return false;
	}

	// 가로 탐색
	public static boolean solveRow(int i, int j, int l) {
		for (int k = 0; k < l / 2; k++) {
			if (A[i][j + k] != A[i][j + l - 1 - k])
				return false;
		}
		return true;
	}

	// 세로 탐색
	public static boolean solveColumn(int i, int j, int l) {
		for (int k = 0; k < l / 2; k++) {
			if (A[i + k][j] != A[i + l - 1 - k][j])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 10; tc++) {
			int t = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
			A = new char[L][L];

			// 글자판 입력
			for (int i = 0; i < L; i++) {
				String str = br.readLine();
				for (int j = 0; j < L; j++) {
					A[i][j] = str.charAt(j);
				}
			}

			for (int i = L; i > 0; i--) {
				if (solve(i)) {
					System.out.println("#" + t + " " + i);
					break;
				}
			}
		}

		br.close();
	}
}
