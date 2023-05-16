package d3.농작물수확하기;

/*
	# 2805. 농작물 수확하기

	- N x N 크기의 농장이 존재
	- 농장의 크기 N은 항상 1 이상 49 이하 홀수
	- 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능
	- 농작물의 가치는 0 ~ 5
		- 정답의 최대치: 49 * 49 모두 5라고 해도 전체 범위를 수확하면 12500 미만 -> Int

	## 입력
	- 첫째 줄: 테스트 케이스 개수 T
	- 각 테스트 케이스에는 농장의 크기와 농작 내 농작물의 가치가 주어짐

	## 출력
	- #t 정답
 */

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static int[][] A;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}
	}

	static void pro(int tc) {
		int s = N / 2;
		int e = N / 2;

		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = s; j <= e; j++) {
				sum += A[i][j];
			}

			if (i < N / 2) {
				s--;
				e++;
			} else {
				s++;
				e--;
			}
		}

		sb.append('#').append(tc).append(' ').append(sum).append('\n');
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
