package 완전탐색.n과m12번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static int[] A, selected, selectedIdx;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N + 1];
		selected = new int[M + 1];
		selectedIdx = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void rec_func(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		} else {
			int last = 0; // 마지막에 사용한 숫자
			int start = selectedIdx[k - 1]; // 시작점은 이전에 고른 숫자의 인덱스
			if (start == 0) {
				start = 1;
			}

			for (int i = start; i <= N; i++) {
				if (last == A[i]) {
					continue;
				}

				last = A[i];
				selectedIdx[k] = i;
				selected[k] = A[i];

				rec_func(k + 1);
				selectedIdx[k] = 0;
				selected[k] = 0;

			}
		}
	}

	static void pro() {
		Arrays.sort(A);

		rec_func(1);

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
