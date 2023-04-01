package 완전탐색.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K, L;
	static int[][] A, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static Queue<Info> snake;
	static Queue<Integer> time, direction; // 왼쪽이 0, 오른쪽이 1

	static class Info {
		int x;
		int y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		A = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			A[x][y] = 1; // 사과 위치
		}

		L = Integer.parseInt(br.readLine());
		time = new LinkedList<>();
		direction = new LinkedList<>();

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			String d = st.nextToken();

			time.add(t);
			if (d.equals("L")) { // 왼쪽
				direction.add(0);
			} else {
				direction.add(1);
			}
		}
	}

	static int rotate(int from, int to) {
		if (to == 0) { // 왼쪽 90도 회전
			if (from == 0) {
				return 3;
			}
			return from - 1;
		} else { // 오른쪽 90도 회전
			if (from == 3) {
				return 0;
			}
			return from + 1;
		}
	}

	static boolean isConflict(int headX, int headY) {
		for (Info info : snake) {
			if (info.x == headX && info.y == headY) {
				return true;
			}
		}
		return false;
	}

	static void pro() {
		int answer = 0;
		snake = new LinkedList<>();

		int x = 1, y = 1, curD = 1;
		snake.add(new Info(x, y));

		while (true) {
			answer++;

			int headX = x + dir[curD][0];
			int headY = y + dir[curD][1];

			if (headX < 1 || headY < 1 || headX > N || headY > N) { // 벽에 부딪히면 끝
				break;
			}

			if (isConflict(headX, headY)) { // 자기 몸과 부딪히면 끝
				break;
			}

			if (A[headX][headY] == 1) { // 사과가 있으면
				A[headX][headY] = 0; // 사과를 먹음
				snake.add(new Info(headX, headY));
			} else { // 사과가 없으면
				snake.add(new Info(headX, headY));
				snake.remove(); // 꼬리 삭제
			}

			if (!time.isEmpty() && !direction.isEmpty()) {
				if (answer == time.peek()) {
					int rt = time.poll();
					int cd = direction.poll();
					curD = rotate(curD, cd);
				}
			}

			x = headX;
			y = headY;
		}

		System.out.println(answer);

	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
