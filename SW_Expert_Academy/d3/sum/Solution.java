package d3.sum;

/*
	# 1209. Sum

	- 100 x 100 배열이 주어질 때, 각 행의 합, 각 열의 합, 각 대각선의 합 중 최대값을 구하는 문제
	- 총 10개의 테스트 케이스가 주어짐
	- 배열의 크기는 100 x 100 으로 동일
	- 각 행의 합이 Integer 범위를 넘어가지 않는다
	- 동일한 최대값이 있을 경우 하나의 값만 출력
 */

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int tc, answer;
	static int[][] A;

	static void input() throws IOException {
		tc = Integer.parseInt(br.readLine());

		// 행 별로 입력을 받으며 미리 계산
		answer = 0;
		A = new int[100][100];
		for (int i = 0; i < 100; i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 100; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				sum += A[i][j];
			}

			answer = Math.max(answer, sum);
		}
	}

	static void pro() {
		int sumCol;
		int sumDownRight = 0;
		int sumDownLeft = 0;

		// 행의 합은 입력을 받을 때 미리 계산함
		for (int i = 0; i < 100; i++) {
			sumCol = 0; // 열의 합
			sumDownRight += A[i][i]; // 우하향 대각선의 합
			sumDownLeft += A[i][99 - i]; // 좌하향 대각선의 합

			for (int j = 0; j < 100; j++) {
				sumCol += A[j][i];
			}
			answer = Math.max(answer, sumCol);
		}
		answer = Math.max(answer, Math.max(sumDownLeft, sumDownRight));

		sb.append('#').append(tc).append(' ').append(answer).append('\n');
	}

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++) {
			input();
			pro();
		}

		System.out.print(sb);
	}

}
