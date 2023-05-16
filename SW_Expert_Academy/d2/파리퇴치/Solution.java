package d2.파리퇴치;

/*
	# 2001. 파리 퇴치

	- N x N 배열 안의 숫자는 해당 영역에 존재하는 파리의 개수를 의미한다
	- M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이고자 한다
	- 내리쳤을 때 최대한 많이 죽은 파리의 개수를 구하는 문제

	## 입력
	- 첫째 줄: 테스트 케이스의 개수 T
	- 각 테스트 케이스의 첫 번째 줄: N M
		- 5 <= N <= 15
		- 2 <= M <= N
	- 각 테스트 케이스의 둘째 줄부터 N개의 줄에 걸쳐 배열이 주어짐
		- 각 영역의 파리 갯수는 30 이하

	## 출력
	- #t 정답

 */

import java.util.*;
import java.io.*;
public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static int[][] A;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int hit(int x, int y) {
		int sum = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				sum += A[x + i][y + j];
			}
		}

		return sum;
	}

	static void pro(int tc) {
		int answer = 0; // 정답의 최대치: 15 x 15 영역의 파리가 모두 30 -> 6,750 마리 -> int

		// 1. (0, 0) 부터 차례대로 M x M 영역의 파리 수를 구한다
		for (int i = 0; i <= N - M; i++) {
			for (int j = 0; j <= N - M; j++) {
				answer = Math.max(answer, hit(i, j));
			}
		}

		sb.append('#').append(tc).append(' ').append(answer).append('\n');
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
