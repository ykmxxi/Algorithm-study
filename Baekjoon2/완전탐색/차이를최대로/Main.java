package 완전탐색.차이를최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, max;
	static int[] A, selected, used;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}

	static int calculate() {
		int sum = 0;

		for (int i = 0; i < N - 1; i++) {
			sum += Math.abs(selected[i] - selected[i + 1]);
		}
		return sum;
	}

	static void rec_func(int k) {
		if (k == N) {
			max = Math.max(max, calculate());
		} else {
			for (int i = 0; i < N; i++) {
				if (used[i] == 0) {
					used[i] = 1;
					selected[k] = A[i];

					rec_func(k + 1);

					used[i] = 0;
					selected[k] = 0;
				}
			}
		}
	}

	static void pro() {
		used = new int[N];
		selected = new int[N];

		rec_func(0);

		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
