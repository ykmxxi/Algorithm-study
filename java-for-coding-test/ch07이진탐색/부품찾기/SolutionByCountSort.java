package ch07이진탐색.부품찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionByCountSort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static int[] B, cnt;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		cnt = new int[1000001];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cnt[Integer.parseInt(st.nextToken())] = 1;
		}

		M = Integer.parseInt(br.readLine());

		B = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		// 계수 정렬
		for (int i = 0; i < M; i++) {
			if (cnt[B[i]] == 1) {
				sb.append("yes").append(' ');
			} else {
				sb.append("no").append(' ');
			}
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
