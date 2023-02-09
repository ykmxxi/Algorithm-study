package 그래프와탐색.나이트의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int l;
	static int[][] dist;
	static int[] cur, dest;
	static int[][] dir = {{-2, -1}, {2, 1}, {-2, 1}, {2, -1}, {-1, -2}, {1, 2}, {-1, 2}, {1, -2}};

	static void input() throws IOException {
		l = Integer.parseInt(br.readLine());
		dist = new int[l][l];
		cur = new int[2];
		dest = new int[2];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2; i++) {
			cur[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2; i++) {
			dest[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void bfs() {
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				dist[i][j] = -1;
			}
		}
		Queue<Integer> que = new LinkedList<>();

		que.add(cur[0]);
		que.add(cur[1]);
		dist[cur[0]][cur[1]] = 0;

		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();

			for (int k = 0; k < 8; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];

				if (nx < 0 || ny < 0 || nx >= l || ny >= l) {
					continue;
				}
				if (dist[nx][ny] != -1) { // 초기화 거리와 다르다면 이미 방문한 곳
					continue;
				}

				que.add(nx);
				que.add(ny);
				dist[nx][ny] = dist[x][y] + 1;
			}
		}
		sb.append(dist[dest[0]][dest[1]]).append('\n');
	}

	static void pro() {
		bfs();
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			T--;
			input();
			pro();
		}
		System.out.println(sb);
	}
}
