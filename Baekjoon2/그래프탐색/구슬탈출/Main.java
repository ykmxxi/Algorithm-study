package 그래프탐색.구슬탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, hx, hy;
	static String[] A;
	static int[][][][] visit;
	static State red, blue;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 위로, 오른쪽, 아래로, 왼쪽

	static class State {
		int rx, ry, bx, by, cnt;

		public State(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new String[N];
		visit = new int[N][M][N][M];
		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();

			for (int j = 0; j < M; j++) {
				if (A[i].charAt(j) == 'R') {
					red = new State(i, j, 0, 0, 0);
				}
				if (A[i].charAt(j) == 'B') {
					blue = new State(0, 0, i, j, 0);
				}
				if (A[i].charAt(j) == 'O') {
					hx = i;
					hy = j;
				}
			}
		}
	}

	static int bfs() {
		Queue<State> q = new LinkedList<>();
		q.add(new State(red.rx, red.ry, blue.bx, blue.by, 1));
		visit[red.rx][red.ry][blue.bx][blue.by] = 1;

		while (!q.isEmpty()) {
			State state = q.poll();
			int curRx = state.rx;
			int curRy = state.ry;
			int curBx = state.bx;
			int curBy = state.by;
			int curCnt = state.cnt;

			if (curCnt > 10) { // 기울인 횟수가 10번이 넘어가면 -1
				return -1;
			}

			for (int k = 0; k < 4; k++) {
				int newRx = curRx;
				int newRy = curRy;
				int newBx = curBx;
				int newBy = curBy;

				boolean isRed = false; // 빨간 공이 구멍에 빠지면 true
				boolean isBlue = false; // 파란 공이 구멍에 빠지면 true

				// 빨간 공 이동
				while (true) {
					if (A[newRx + dir[k][0]].charAt(newRy + dir[k][1]) == '#') {
						break;
					}
					newRx += dir[k][0];
					newRy += dir[k][1];

					if (newRx == hx && newRy == hy) { // 이동 중 구멍을 만나면
						isRed = true;
						break;
					}
				}

				// 파란 공 이동
				while (true) { // 벽을 만날 때 까지 이동
					if (A[newBx + dir[k][0]].charAt(newBy + dir[k][1]) == '#') {
						break;
					}
					newBx += dir[k][0];
					newBy += dir[k][1];

					if (newBx == hx && newBy == hy) { // 이동 중 구멍을 만나면
						isBlue = true;
						break;
					}
				}

				// 파란 공이 구멍에 빠지면 실패
				if (isBlue)
					continue;
				if (isRed && !isBlue) { // 빨간 공만 빠져나가고 파란 공이 빠져나가지 않았으면 종료
					return curCnt;
				}

				// 둘 다 구멍에 빠지지 않았는데 이동할 위치가 같은 경우는 기울이기 전 위치를 비교해 위치를 조정해줘야 함
				if (newRx == newBx && newRy == newBy) {
					if (k == 0) { // 위쪽으로 기울이기
						// 더 큰 x값을 가지는 구슬이 뒤로 감
						if (curRx > curBx)
							newRx += 1;
						else
							newBx += 1;
					} else if (k == 1) { // 오른쪽으로 기울이기
						// 더 작은 y값을 가지는 구슬이 뒤로 감
						if (curRy < curBy)
							newRy -= 1;
						else
							newBy -= 1;
					} else if (k == 2) { // 아래쪽으로 기울이기
						// 더 작은 x값을 가지는 구슬이 뒤로 감
						if (curRx < curBx)
							newRx -= 1;
						else
							newBx -= 1;
					} else { // 왼쪽으로 기울이기
						// 더 큰 y값을 가지는 구슬이 뒤로 감
						if (curRy > curBy)
							newRy += 1;
						else
							newBy += 1;
					}
				}

				// 두 구슬이 이동할 위치가 처음 방문하는 곳인 경우 큐에 추가
				if (visit[newRx][newRy][newBx][newBy] == 0) {
					visit[newRx][newRy][newBx][newBy] = 1;
					q.add(new State(newRx, newRy, newBx, newBy, curCnt + 1));
				}

			}
		}

		return -1;
	}

	static void pro() {
		System.out.println(bfs());
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
