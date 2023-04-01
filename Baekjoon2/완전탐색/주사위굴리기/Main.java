package 완전탐색.주사위굴리기;

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

	static int N, M, x, y, K;
	static Queue<Integer> order;
	static int[][] A, dir = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 1: 동쪽, 2: 서쪽, 3: 북쪽, 4: 남쪽
	static Cube cube;

	static class Cube {
		int one, two, three, four, five, six;
		// one: 위, six: 아래 짝
		// two - five 짝 -> 남북 굴릴때만 영향을 받음
		// three - four 짝 -> 동서 굴릴때만 영향을 받음
		/*
			2
		  4 1 3
		    5
		    6
		 */

		public Cube() {
		}

		public Cube(int one, int two, int three, int four, int five, int six) {
			this.one = one;
			this.two = two;
			this.three = three;
			this.four = four;
			this.five = five;
			this.six = six;
		}
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		order = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			order.add(Integer.parseInt(st.nextToken()));
		}
	}

	static Cube roll(int dir) {

		if (dir == 1) { // 동
			return new Cube(cube.four, cube.two, cube.one, cube.six, cube.five, cube.three);
		} else if (dir == 2) { // 서
			return new Cube(cube.three, cube.two, cube.six, cube.one, cube.five, cube.four);
		} else if (dir == 3) { // 북
			return new Cube(cube.five, cube.one, cube.three, cube.four, cube.six, cube.two);
		} else { // 남
			return new Cube(cube.two, cube.six, cube.three, cube.four, cube.one, cube.five);
		}
	}

	static void pro() {
		cube = new Cube(); // 처음엔 모두 0

		while (!order.isEmpty()) {
			int curD = order.poll();
			int nx = x + dir[curD][0];
			int ny = y + dir[curD][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue; // 바깥으로 넘어가면 명령 무시, 출력 X
			}

			cube = roll(curD); // 굴리기

			if (A[nx][ny] == 0) { // 이동한 칸 숫자가 0 이면 주사위 바닥면 숫자 복사
				A[nx][ny] = cube.six;
			} else { // 이동한 칸 숫자가 0이 아니면, 주사위 바닥면에 칸의 수가 복사되고 칸은 0이
				cube.six = A[nx][ny];
				A[nx][ny] = 0;
			}

			sb.append(cube.one).append('\n');// 윗면 출력

			x = nx;
			y = ny;
		}

		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
