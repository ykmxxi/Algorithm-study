package 완전탐색.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, answer = Integer.MAX_VALUE;
	static int[] selected;
	static ArrayList<Info> store, home;

	static class Info {
		int x;
		int y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		home = new ArrayList<>();
		store = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				String tmp = st.nextToken();
				if (tmp.equals("1")) {
					home.add(new Info(i, j));
				}
				if (tmp.equals("2")) {
					store.add(new Info(i, j));
				}
			}
		}
	}

	static int calculate() {
		int sum = 0;
		for (Info h : home) {
			int diff = 100;
			for (int index : selected) {
				Info st = store.get(index);
				diff = Math.min(diff, (Math.abs(st.x - h.x) + Math.abs(st.y - h.y)));
			}
			sum += diff;
		}
		return sum;
	}

	static void rec_func(int k) {
		if (k == M) {
			answer = Math.min(answer, calculate());
		} else {
			int start;
			if (k == 0) {
				start = 0;
			} else {
				start = selected[k - 1] + 1;
			}

			for (int i = start; i < store.size(); i++) {
				selected[k] = i;
				rec_func(k + 1);
				selected[k] = 0;
			}
		}
	}

	static void pro() {
		selected = new int[M];

		rec_func(0);

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
