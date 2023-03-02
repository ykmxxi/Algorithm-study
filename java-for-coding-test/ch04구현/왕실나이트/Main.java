package ch04구현.왕실나이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static String position;
	static int row, col, answer;
	static int[][] dir = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

	static void input() throws IOException {
		position = br.readLine();
		row = position.charAt(1) - '0';
		col = position.charAt(0) - 'a' + 1;
	}

	static void dfs(int x, int y) {
		for (int k = 0; k < 8; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx < 1 || ny < 1 || nx > 8 || ny > 8) {
				continue;
			}

			answer++;
		}
	}

	static void pro() {
		answer = 0;
		dfs(row, col);
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
