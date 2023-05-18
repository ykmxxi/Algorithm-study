package d2.중간평균값구하기;

/*
	# 1984. 중간 평균값 구하기
	- 10개 수를 입력 받아 최대, 최소를 제외한 나머지 평균값을 출력하는 문제
	- 소수점 첫째 자리에서 반올림한 정수를 출력
	- 각 수는 0 이상 10000 이하의 정수 -> 평균을 구하기 위한 합계 값이 int 범위 내

	## 입력
	- 첫째 줄: 테케 T
	- 각 테케 첫째 줄: 공백을 기준으로 10개의 숫자가 주어짐

	## 출력
	- #tc 정답
 */

import java.util.*;
import java.io.*;

public class Solution {
	private static final float MOD = 8.0f;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] A;

	static void input() throws IOException {
		A = new int[10];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 10; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro(int tc) {
		Arrays.sort(A);

		int sum = 0;
		for (int i = 1; i < A.length - 1; i++) {
			sum += A[i];
		}

		int answer = Math.round(sum / MOD);
		sb.append('#').append(tc).append(' ').append(answer).append('\n');
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
