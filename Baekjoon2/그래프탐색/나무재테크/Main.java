package 그래프탐색.나무재테크;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, K;
	static int[][] map, A, dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	static PriorityQueue<Tree> trees;
	static ArrayList<Tree> dead;

	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int z;

		public Tree(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Tree o) {
			return this.z - o.z; // 나이가 어린 순으로 양분을 먹는다.
		}
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		A = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5; // 맨 처음 양분은 5
			}
		}

		trees = new PriorityQueue<>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			trees.add(new Tree(x, y, z));
		}
	}

	static void spring() {
		ArrayList<Tree> tmp = new ArrayList<>();
		dead = new ArrayList<>();

		while (!trees.isEmpty()) {
			Tree cur = trees.poll();

			if (map[cur.x][cur.y] >= cur.z) { // 양분이 더 많다면
				map[cur.x][cur.y] -= cur.z;
				tmp.add(new Tree(cur.x, cur.y, cur.z + 1));
			} else { // 양분이 더 적으면 죽게됨
				dead.add(new Tree(cur.x, cur.y, cur.z));
			}
		}

		trees.addAll(tmp);
	}

	static void summer() {
		for (Tree tree : dead) {
			map[tree.x][tree.y] += tree.z / 2;
		}
	}

	static void fall() {
		ArrayList<Tree> tmp = new ArrayList<>();

		for (Tree tree : trees) {
			if (tree.z % 5 == 0) {
				for (int k = 0; k < 8; k++) {
					int nx = tree.x + dir[k][0];
					int ny = tree.y + dir[k][1];

					if (nx < 1 || ny < 1 || nx > N || ny > N) {
						continue;
					}
					tmp.add(new Tree(nx, ny, 1));
				}
			}
		}

		trees.addAll(tmp);
	}

	static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += A[i][j];
			}
		}
	}

	static void pro() {
		while (K-- > 0) {
			// 봄: 모든 나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가
			spring();

			// 여름: 봄에 죽은 나무가 양분으로 변하게 된다.
			summer();

			// 가을: 나무가 번식
			fall();

			// 겨울: 로봇이 돌아다니면 양분을 추가
			winter();
		}

		System.out.println(trees.size());
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
