package 그래프와탐색.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, group_cnt; // 지도의 크기, 단지에 속한 집의 수
	static String[] A;
	static boolean[][] visited; // 방문 여부 체크
	static ArrayList<Integer> group; // 단지
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new String[N];

		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();
		}
		visited = new boolean[N][N];
	}

	static void dfs(int x, int y) {
		group_cnt++;
		visited[x][y] = true;

		// 인접한(상하좌우) 집으로 새로운 방문
		for (int k = 0; k < 4; k++) {
			// (x, y) -> dir[k]
			int newX = x + dir[k][0];
			int newY = y + dir[k][1];

			if (newX < 0 || newY < 0 || newX >= N || newY >= N) { // 범위를 벗어나거나
				continue;
			}
			if (A[newX].charAt(newY) == '0') { // 집이 존재하지 않거나
				continue;
			}
			if (visited[newX][newY]) { // 이미 방문한 집이라면
				continue;
			}
			dfs(newX, newY);
		}

	}

	static void pro() {
		group = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && A[i].charAt(j) == '1') { // 방문하지 않은 집이 존재하는 정점에 대해 dfs
					group_cnt = 0;
					dfs(i, j);
					group.add(group_cnt);
				}
			}
		}

		Collections.sort(group);
		sb.append(group.size()).append('\n');
		for (int cnt : group) {
			sb.append(cnt).append('\n');
		}

		System.out.println(sb);

	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
