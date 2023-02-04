package 그래프와탐색.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static String[] A;
	static boolean[][] visit;
	static int[][] dist;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new String[N];

		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();
		}
		visit = new boolean[N][M];
		dist = new int[N][M];
	}

	static void bfs(int x, int y) {
		// dist 배열 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j] = -1;
			}
		}

		// (x, y)를 큐에 넣고 visit, dist 값 초기화
		Queue<Integer> que = new LinkedList<>();
		que.add(x);
		que.add(y);
		dist[x][y] = 1; // 시작점, 도착점도 포함이니 1로 시작
		visit[x][y] = true;

		while (!que.isEmpty()) {
			x = que.poll();
			y = que.poll();
			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if (A[nx].charAt(ny) == '0') { // 이동할 수 없는 칸
					continue;
				}
				if (visit[nx][ny]) {
					continue;
				}

				que.add(nx);
				que.add(ny);
				visit[nx][ny] = true;
				dist[nx][ny] = dist[x][y] + 1;
			}
		}
	}

	static void pro() {
		// 시작점 (0, 0) 부터 탐색 시작
		bfs(0, 0);

		// (N - 1, M - 1) 까지 필요한 최소 이동 횟수
		System.out.println(dist[N - 1][M - 1]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
