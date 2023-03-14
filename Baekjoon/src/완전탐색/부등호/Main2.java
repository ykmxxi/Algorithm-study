package 완전탐색.부등호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int k;
	static long min, max;
	static String minS, maxS;
	static char[] A;
	static int[] visit, B;

	static void input() throws IOException {
		k = Integer.parseInt(br.readLine());

		A = new char[k];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
			A[i] = st.nextToken().charAt(0);
		}

		visit = new int[10];
	}

	static boolean check() {
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (A[i] == '<') {
				if (B[i] < B[i + 1]) {
					cnt++;
				}
			} else {
				if (B[i] > B[i + 1]) {
					cnt++;
				}
			}
		}

		return cnt == k;
	}

	static void rec_func(int digit) {
		if (digit == k + 1) {
			for (int n : B) {
				sb.append(n);
			}

			if (check()) {
				if (min > Long.parseLong(sb.toString())) {
					minS = sb.toString();
					min = Long.parseLong(sb.toString());
				}
				if (max < Long.parseLong(sb.toString())) {
					maxS = sb.toString();
					max = Long.parseLong(sb.toString());
				}
			}
			sb = new StringBuilder();
		} else {
			for (int candidate = 0; candidate < 10; candidate++) {
				if (visit[candidate] == 1) {
					continue;
				}
				visit[candidate] = 1;
				B[digit] = candidate;

				rec_func(digit + 1);
				visit[candidate] = 0;
				B[digit] = 0;
			}
		}
	}

	static void pro() {
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		B = new int[k + 1];
		rec_func(0);

		System.out.print(maxS + "\n" + minS);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
