package 동적프로그래밍.기타리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, S, M;
	static int[] V;
	static boolean[][] Dy;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		V = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}

		Dy = new boolean[N + 1][M + 1];
	}

	static void pro() {
		int answer = 0;

		Dy[0][S] = true;
		for (int i = 1; i <= N; i++) {
			boolean flag = false;
			answer = 0;

			for (int prev = 0; prev <= M; prev++) {
				if (!Dy[i - 1][prev]) {
					continue;
				}

				for (int cur : new int[] {prev - V[i], prev + V[i]}) {
					if (cur < 0 || cur > M) {
						continue;
					}
					answer = Math.max(answer, cur);
					Dy[i][cur] = true;
					flag = true;
				}
			}

			if (!flag) {
				answer = -1;
				break;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
