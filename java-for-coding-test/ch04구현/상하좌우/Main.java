package ch04구현.상하좌우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, x, y;
	static char[] plan, type = {'U', 'D', 'L', 'R'};
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		plan = new char[105];

		st = new StringTokenizer(br.readLine(), " ");
		int index = 1;
		while (st.hasMoreTokens()) {
			plan[index] = st.nextToken().charAt(0);
			index++;
		}
	}

	static void pro() {
		x = 1;
		y = 1;

		for (char move : plan) {
			int nx = x;
			int ny = y;
			for (int i = 0; i < 4; i++) {
				if (move == type[i]) {
					nx += dir[i][0];
					ny += dir[i][1];
				}
			}

			if (nx < 1 || ny < 1 || nx > N || ny > N) {
				continue;
			}
			x = nx;
			y = ny;
		}

		sb.append(x).append(' ').append(y);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
