package d3.농작물수확하기;

import java.util.*;
import java.io.*;

public class Solution2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, answer;
	static int[][] A, visit, dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	static class Info {
		int x;
		int y;
		int depth;

		public Info(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}
	}

	static void bfs(int sx, int sy, int depth) {
		PriorityQueue<Info> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.depth));

		que.add(new Info(sx, sy, 1));
		visit[sx][sy] = 1;
		answer += A[sx][sy];

		while (!que.isEmpty()) {
			Info info = que.poll();

			for (int k = 0; k < 4; k++) {
				int nx = info.x + dir[k][0];
				int ny = info.y + dir[k][1];
				int nd = info.depth + 1;

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				if (visit[nx][ny] == 1) {
					continue;
				}
				if (nd > depth) {
					continue;
				}

				que.add(new Info(nx, ny, nd));
				visit[nx][ny] = 1;
				answer += A[nx][ny];
			}
		}

	}

	static void pro(int tc) {
		int sx = N / 2;
		int sy = N / 2;
		int depth = (N / 2) + 1;

		answer = 0;
		visit = new int[N][N];
		bfs(sx, sy, depth);

		sb.append('#').append(tc).append(' ').append(answer).append('\n');
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			input();
			pro(i);
		}

		System.out.print(sb);
	}

}
