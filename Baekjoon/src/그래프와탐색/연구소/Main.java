package 그래프와탐색.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, B, answer;
	static int[][] A, blank;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N + 1][M + 1];
		blank = new int[N * M + 1][2];
		visit = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	// 바이러스 퍼뜨리기, Multi-source BFS
	static void bfs() {
		Queue<Integer> que = new LinkedList<>();

		// 모든 바이러스가 시작점으로 가능하니, 전부 큐에 넣는다 (Multi-source BFS)
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				visit[i][j] = false;
				if (A[i][j] == 2) {
					// 큐에 행과 열을 차례대로 삽입하면, 값을 빼올때 도 행, 열을 차례대로 가져올 수 있다.
					que.add(i); // 행
					que.add(j); // 열
					visit[i][j] = true;
				}
			}
		}

		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();

			for (int k = 0; k < 4; k++) { // 상하좌우 바이러스 확산 확인
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];

				if (nx < 1 || ny < 1 || nx > N || ny > M) {
					continue;
				}
				if (A[nx][ny] != 0) {
					continue;
				}
				if (visit[nx][ny]) {
					continue;
				}

				visit[nx][ny] = true;
				que.add(nx);
				que.add(ny);
			}
		}

		// 탐색 종료 후 안전 영역의 넓이를 계산하고 정답 갱신
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (A[i][j] == 0 && !visit[i][j]) {
					cnt++;
				}
			}
		}

		answer = Math.max(answer, cnt);
	}

	// idx 번째 빈 칸에 벽을 세울 지 결정하고, 이전까지 selected_cnt 만큼의 벽을 세웠음
	static void dfs(int idx, int selected_cnt) {
		if (selected_cnt == 3) { // 벽을 3개 모두 세웠음
			bfs(); // 벽을 모두 세웠으니 바이러스 확산 진행
			return;
		}

		if (idx > B) { // 더 세울 수 있는 벽이 없는 상태
			return;
		}

		// 벽을 세움
		A[blank[idx][0]][blank[idx][1]] = 1;
		dfs(idx + 1, selected_cnt + 1);

		// 벽을 세우지 않음
		A[blank[idx][0]][blank[idx][1]] = 0;
		dfs(idx + 1, selected_cnt);
	}

	static void pro() {
		// 모든 벽의 위치를 먼저 탐색, 빈 공간은 blank 에 저장
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (A[i][j] == 0) {
					B++;
					blank[B][0] = i;
					blank[B][1] = j;
				}
			}
		}

		// 벽을 3개 세우는 모든 방법을 확인
		dfs(1, 0);
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
