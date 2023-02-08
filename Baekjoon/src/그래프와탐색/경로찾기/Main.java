package 그래프와탐색.경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static int[][] G;
	static ArrayList<Integer>[] path;
	static boolean[] visit;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		G = new int[N][N];
		path = new ArrayList[N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
			path[i] = new ArrayList<>();
		}
	}

	static void bfs(int start) { // start 에서 갈 수 있는 모든 정점들을 탐색
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			visit[i] = false; // 시작점이 바뀌면 visit 배열 초기화
		}

		que.add(start);
		visit[start] = false; // start -> start 여부 판독을 위해

		while (!que.isEmpty()) {
			int x = que.poll();

			for (int y = 0; y < N; y++) {
				if (G[x][y] == 0) {
					continue;
				}
				if (visit[y]) {
					continue;
				}
				que.add(y);
				visit[y] = true;
			}
		}

		for (int i = 0; i < N; i++) {
			if (visit[i]) {
				path[start].add(i); // start 에서 갈수 있는 정점들을 경로에 추가
			}
		}
	}

	static void pro() {
		for (int i = 0; i < N; i++) {
			bfs(i);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (path[i].contains(j)) {
					sb.append(1).append(' ');
				} else {
					sb.append(0).append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
