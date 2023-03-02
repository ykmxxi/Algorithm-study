package ch04구현.게임개발;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, A, B, d, answer;
	static int[][] map, visit;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new int[N][M]; // 0: 아직 방문 x, 1: 방문한 지점
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void turnLeft() {
		if (--d == -1) {
			d = 3;
		}
	}

	static void dfs(int x, int y) {
		answer++;
		visit[x][y] = 1;
		int turnCnt = 0;

		while (true) {
			turnLeft(); // 왼쪽으로 회전
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];

			// 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
			if (visit[nx][ny] == 0 && map[nx][ny] == 0) {
				visit[nx][ny] = 1;
				x = nx;
				y = ny;
				answer++;
				turnCnt = 0;
				continue;
			} else { // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
				turnCnt += 1;
			}

			// 네 방향 모두 갈 수 없는 경우
			if (turnCnt == 4) {
				nx = x - dir[d][0];
				ny = y - dir[d][1];

				if (map[nx][ny] == 0) { // 뒤로 갈 수 있다면 이동하기
					x = nx;
					y = ny;
				} else { // 뒤가 바다로 막혀있는 경우
					break;
				}

				turnCnt = 0;
			}
		}
	}

	static void pro() {
		// 캐릭터가 서 있는 위치에서 dfs 시작
		dfs(A, B);

		// 정답 출력
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
