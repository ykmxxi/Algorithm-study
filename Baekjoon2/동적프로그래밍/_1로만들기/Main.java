package 동적프로그래밍._1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static int[] dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		dy = new int[1000001];
	}

	static void pro() {
		// 초기값 설정
		dy[1] = 0;
		dy[2] = 1;
		dy[3] = 1;

		for (int i = 4; i < dy.length; i++) {
			if (i % 3 == 0 && i % 2 == 0) {
				dy[i] = Math.min(dy[i - 1] + 1, Math.min(dy[i / 3] + 1, dy[i / 2] + 1));
				continue;
			}
			if (i % 3 == 0) {
				dy[i] = Math.min(dy[i / 3] + 1, dy[i - 1] + 1);
				continue;
			}
			if (i % 2 == 0) {
				dy[i] = Math.min(dy[i / 2] + 1, dy[i - 1] + 1);
				continue;
			}
			dy[i] = dy[i - 1] + 1;
		}

		System.out.println(dy[N]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
