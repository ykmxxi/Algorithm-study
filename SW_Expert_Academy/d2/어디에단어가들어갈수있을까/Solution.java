package d2.어디에단어가;

/*
	# 1979. 어디에 단어가 들어갈 수 있을까

	- N x N 크기의 단어 퍼즐을 만들려고 한다
	- 입력으로 단어 퍼즐의 모양이 주어질 때 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력
	- 5 <= N <= 15
	- 2 <= K <= N

	## 입력
	- 첫 줄: 총 테케 개수 T
	- 테케 첫 줄: N K
	- 테케 둘째 줄부터 N개의 줄에 걸쳐 퍼즐 정보가 주어짐
		- 1: 흰색 부분 -> 단어가 들어갈 수 있는 곳
		- 0: 검은색 부분
 */

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, K;
	static int[][] A;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro(int tc) {
		int answer = 0;
		Stack<Integer> stack;

		// 가로 체크
		for (int i = 0; i < N; i++) {
			stack = new Stack<>();

			for (int num : A[i]) {
				if (num == 0) {
					if (stack.size() == K) {
						answer++;
					}
					stack.clear();
				} else {
					stack.push(1);
				}
			}

			if (stack.size() == K) {
				answer++;
			}
		}

		// 세로 체크
		for (int i = 0; i < N; i++) {
			stack = new Stack<>();

			for (int j = 0; j < N; j++) {
				if (A[j][i] == 0) {
					if (stack.size() == K) {
						answer++;
					}
					stack.clear();
				} else {
					stack.push(1);
				}
			}

			if (stack.size() == K) {
				answer++;
			}
		}

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
