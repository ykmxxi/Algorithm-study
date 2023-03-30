package ch07이진탐색.부품찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SolutionByHashSet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static HashSet<Integer> A;
	static int[] B;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		M = Integer.parseInt(br.readLine());

		B = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		for (int target : B) {
			if (A.contains(target)) {
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
