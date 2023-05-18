package d3.n_queen;

/*
	# 2806. N-Queen

	- 8 x 8 체스판에 8개의 퀸을 서로 공격하지 못하게 하는 문제
	- 퀸은 같은 행(가로), 열(세로), 대각선(우하향, 좌하향) 위에 있는 말을 공격 가능
	- N x N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수를 구하는 문제

	## 입력
	- 첫째 줄: T
	- 둘째 줄: N
		1 <= N <= 10

	## 출력
	- #tc 정답
 */

import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, answer;
	static int[] selected; // selected[i] -> i행 selected[i]열에 퀸이 놓여있다

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		selected = new int[N];
	}

	static boolean canAttack(int r1, int c1, int r2, int c2) {
		// 행 마다 1개씩 고르기 때문에 같은 행 공격 가능성은 없음
		// 같은 열 공격 가능
		if (c1 == c2) {
			return true;
		}

		// 우하향 대각선
		if (r2 - r1 == c2 - c1) {
			return true;
		}

		// 좌하향 대각선 (0, N - 1), (1, N - 2)
		if (r1 + c1 == r2 + c2) {
			return true;
		}

		return false;
	}

	static void rec_func(int depth) {
		if (depth == N) {
			answer++;
		} else {
			for (int col = 0; col < N; col++) { // 첫 번째 행 퀸을 0 ~ N - 1 까지 놓고 다음 행 차레대로
				boolean flag = true;

				for (int row = 0; row < depth; row++) { // 0번 행부터 현재 선택한 행 전까지 현재 선택한 위치에서 공격 가능 지점이 있는지 탐색
					if (canAttack(depth, col, row, selected[row])) {
						flag = false;
						break;
					}
				}

				if (flag) { // 현재 depth 행 에서 해당 col 에 놓을 수 있으면
					selected[depth] = col; // depth 행 selected[depth] 열에 퀸을 놓고

					rec_func(depth + 1);; // 다음 행으로 이동

					selected[depth] = 0; // 초기화
				}
			}
		}
	}

	static void pro(int tc) {
		answer = 0;

		rec_func(0); // 0행 부터 시작

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
