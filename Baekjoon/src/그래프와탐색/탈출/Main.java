package 그래프와탐색.탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int R, C;
	static String[] A;
	static boolean[][] visit;
	static int[][] dist_water;
	static int[][] dist;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		A = new String[R];

		for (int i = 0; i < R; i++) {
			A[i] = br.readLine();
		}
		visit = new boolean[R][C];
		dist_water = new int[R][C];
		dist = new int[R][C];
	}

	static void bfs_water() {
		Queue<Integer> que = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				dist_water[i][j] = -1;
				visit[i][j] = false;

				if (A[i].charAt(j) == '*') {
					que.add(i);
					que.add(j);
					dist_water[i][j] = 0;
					visit[i][j] = true;
				}
			}
		}

		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
					continue;
				}
				if (A[nx].charAt(ny) != '.') { // 비어있는 곳이 아니면 넘어감
					continue;
				}
				if (visit[nx][ny]) { // 이미 방문한 곳이면 넘어감
					continue;
				}

				visit[nx][ny] = true;
				dist_water[nx][ny] = dist_water[x][y] + 1;
				que.add(nx);
				que.add(ny);
			}
		}

	}

	static void bfs() {
		Queue<Integer> que = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				dist[i][j] = -1;
				visit[i][j] = false;

				if (A[i].charAt(j) == 'S') {
					que.add(i);
					que.add(j);
					dist[i][j] = 0;
					visit[i][j] = false;
				}
			}
		}

		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0], ny = y + dir[k][1];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
					continue;  // 지도를 벗어나는 곳으로 가는가?
				}
				if (A[nx].charAt(ny) != '.' && A[nx].charAt(ny) != 'D') {
					continue;  // 갈 수 있는 칸인지 확인해야 한다.
				}
				if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist[x][y] + 1) {
					continue;  // 물에 잠기지는 않는가?
				}
				if (visit[nx][ny]) {
					continue;  // 이미 방문한 적이 있는 곳인가?
				}

				que.add(nx);
				que.add(ny);
				visit[nx][ny] = true;
				dist[nx][ny] = dist[x][y] + 1;
			}
		}
	}

	static void pro() {
		bfs_water();

		bfs();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i].charAt(j) == 'D') {
					if (dist[i][j] == -1) {
						System.out.println("KAKTUS");
					} else {
						System.out.println(dist[i][j]);
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
