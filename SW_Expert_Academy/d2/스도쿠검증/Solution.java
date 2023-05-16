package d2.스도쿠검증;

/*
	# 1974. 스도쿠 검증

	- 스도쿠는 숫자퍼즐로 9 x 9 배열에 1 부터 9 까지의 숫자를 채워넣는 퍼즐
	- 같은 줄(행, 열)에 1 ~ 9 숫자를 한번씩만 놓고, 3 x 3 크기의 배열에 1 ~ 9 까지의 숫자가 겹치면 안된다
	- 입력으로 스도쿠 퍼즐이 주어졌을 때 겹치는 숫자가 없는 경우 1, 그렇지 않을 경우 0 출력

	## 입력
	- 첫째 줄: 총 테스트 케이스의 개수 T
		- 다음 줄 부터 각 테스트 케이스가 주어짐
		- 9 x 9 개의 퍼즐이 T개 주어짐

	## 출력
	- #t 정답
 */

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] A;
	static int[] used;

	static void input() throws IOException {
		A = new int[9][9];

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static boolean check(int x, int y) {
		used = new int[10];

		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (used[A[i][j]] == 0) {
					used[A[i][j]] = 1;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	static boolean validate() {
		// 1. 행 체크
		for (int i = 0; i < 9; i++) {
			used = new int[10];

			for (int j = 0; j < 9; j++) {
				if (used[A[i][j]] == 0) {
					used[A[i][j]] = 1;
				} else {
					return false;
				}
			}

		}

		// 2. 열 체크
		for (int i = 0; i < 9; i++) {
			used = new int[10];

			for (int j = 0; j < 9; j++) {
				if (used[A[j][i]] == 0) {
					used[A[j][i]] = 1;
				} else {
					return false;
				}
			}
		}

		// 3. 3 x 3 격자 체크
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j+= 3) {
				if (!check(i, j)) {
					return false;
				}
			}
		}

		return true;
	}

	static void pro(int tc) {
		sb.append('#').append(tc).append(' ');

		if (validate()) {
			sb.append(1);
		} else {
			sb.append(0);
		}

		sb.append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			input();
			pro(i + 1);
		}

		System.out.println(sb);
	}

}
