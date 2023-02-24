package 그래프와탐색.알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, DIST = 1; // N = R, M = C
	static String[] A;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static boolean[] used;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();
		}

		used = new boolean[26];
	}

	static void dfs(int x, int y, int depth) {
		DIST = Math.max(DIST, depth);
		used[A[x].charAt(y) - 'A'] = true;

		for (int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) { // 움직일 수 없는 칸은 넘어감
				continue;
			}
			if (used[A[nx].charAt(ny) - 'A']) { // 이미 사용한 알파벳은 넘어감
				continue;
			}

			dfs(nx, ny, depth + 1);
			used[A[nx].charAt(ny) - 'A'] = false; // dfs 가 끝나면 초기화
		}
	}

	static void pro() {
		dfs(0, 0, 1);
		System.out.println(DIST);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
