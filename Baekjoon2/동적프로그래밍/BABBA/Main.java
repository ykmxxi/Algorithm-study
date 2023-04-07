package 동적프로그래밍.BABBA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int K;
	static int[][] dy;

	static void input() throws IOException {
		K = Integer.parseInt(br.readLine());
		dy = new int[46][2];
	}

	static void pro() {
		// 초기값 설정
		dy[0][0] = 1;
		dy[1][1] = 1;

		for (int i = 2; i <= 45; i++) {
			for (int j = 0; j <= 1; j++) {
				dy[i][j] = dy[i - 1][j] + dy[i - 2][j]; // 점화식
			}
		}

		sb.append(dy[K][0]).append(' ').append(dy[K][1]);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
