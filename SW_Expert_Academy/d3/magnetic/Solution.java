package d3.magnetic;

/*
	# 1220. Magnetic
	- 푸른 자성체: N극에 끌림, 붉은 자성체: S극에 끌림
	- 시간이 흐른 뒤 자성체들이 서로 충돌해 남아있는 교착 상태의 개수를 구하는 문제
	- N극은 위, S극은 아래에 존재한다
	- 테이블의 크기는 100 x 100

	## 입력
	- 테스트 케이스는 10개
	- 테케 첫째 줄: 100
	- 둘째 줄부터 100개의 줄에 걸쳐 100 x 100 크기의 테이블 정보
		1: N극 성질을 가지는 자성체
		2: S극 성질을 가지는 자성체
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
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro(int tc) {
		// 1은 N극 성질을 가짐 -> S극으로 떨어짐
		// 2는 S극 성질을 가짐 -> N극으로 올라감

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[j][i] == 0) {
					continue;
				}

				if (A[j][i] == 1) { // 떨어뜨린다
					if (j == N - 1) { //
						A[j][i] = 0;
						continue;
					}

					for (int k = j + 1; k < N; k++) {
						if (A[k][i] == 0 || A[k][i] == 1) {
							continue;
						}
						if (A[k][i] == 2) { // 교착상태를 만남
							break;
						}
						A[j][i] = 0; // 교차상태를 만나지 않으면 떨어뜨림
					}
				} else { // 올린다
					if (j == 0) {
						A[j][i] = 0;
						continue;
					}

					for (int k = j - 1; k >= 0; k--) {
						if (A[k][i] == 0 || A[k][i] == 2) {
							continue;
						}
						if (A[k][i] == 1) {
							break;
						}
						A[j][i] = 0;
					}
				}
			}
		}

		int answer = 0;
		// 교착상태 개수 구하기
		for (int i = 0; i < N; i++) {
			Stack<Integer> stack = new Stack<>();

			for (int j = 0; j < N; j++) {
				if (A[j][i] == 0) {
					continue;
				}

				if (A[j][i] == 1) {
					stack.push(1);
				} else {
					if (stack.size() != 0) { // 스택 사이즈가 0이면 같은 교착상태인 것
						answer++;
						stack.clear();
					}
				}
			}
		}

		sb.append('#').append(tc).append(' ').append(answer).append('\n');

	}

	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= 10; i++) {
			input();
			pro(i);
		}

		System.out.print(sb);
	}

}
