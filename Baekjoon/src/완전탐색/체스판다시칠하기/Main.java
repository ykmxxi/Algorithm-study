package 완전탐색.체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static String[] A;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();
		}
	}

	static int getSolution(int x, int y) {
		String[] whiteBoard = {"WBWBWBWB", "BWBWBWBW"};
		int cnt = 0;

		for (int i = 0; i < 8; i++) {
			int row = x + i;

			for (int j = 0; j < 8; j++) {
				int col = y + j;
				if (A[row].charAt(col) != whiteBoard[row % 2].charAt(j)) {
					cnt++;
				}
			}
		}

		return Math.min(cnt, 64 - cnt);
	}

	static void pro() {
		int answer = Integer.MAX_VALUE;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int WB = getSolution(i, j);

				if (answer > WB) {
					answer = WB;
				}
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
