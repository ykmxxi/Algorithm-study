package 패캠제작문제1.전구;

/*
	N개의 전구가 있고 맨 왼쪽 전구를 첫 번째라고 한다
	전구의 상태는 두 가지, 이를 숫자로 표현 -> 1(전구가 켜져 있는 상태), 0 (꺼져 있는 상태)
	전구 제어 명령어는 1번 부터 4번 까지
		1번: [i, x]: i번째 전구의 상태를 x로 변경
		2번: [l, r]: l번째 부터 r번째 까지의 전구의 상태를 변경 (1 -> 0, 0 -> 1)
		3번: [l, r]: l번째 부터 r번째 까지의 전구를 끈다 (0 으로 변경)
		4번: [l, r]: l번째 부터 r번째 까지의 전구를 킨다 (1 로 변경)
	명령어를 다 수행한 결과 전구는 어떤 상태 인지
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static int[] A;
	static int[][] order;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		order = new int[M + 1][3];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				order[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() {
		for (int i = 1; i <= M; i++) {
			if (order[i][0] == 1) {
				A[order[i][1]] = order[i][2];
			}
			if (order[i][0] == 2) {
				for (int j = order[i][1]; j <= order[i][2]; j++) {
					if (A[j] == 0) {
						A[j] = 1;
					} else {
						A[j] = 0;
					}
				}
			}
			if (order[i][0] == 3) {
				for (int j = order[i][1]; j <= order[i][2]; j++) {
					A[j] = 0;
				}

			}
			if (order[i][0] == 4) {
				for (int j = order[i][1]; j <= order[i][2]; j++) {
					A[j] = 1;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(A[i]).append(' ');
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
