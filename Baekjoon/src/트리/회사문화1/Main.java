package 트리.회사문화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static ArrayList<Integer>[] children;
	static int[] score;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		children = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			children[i] = new ArrayList<>();
		}
		score = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int par = Integer.parseInt(st.nextToken());
			if (par == -1) {
				continue;
			}
			children[par].add(i);
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			score[x] += w;
		}
	}

	static void dfs(int x) {
		for (int y : children[x]) {
			score[y] += score[x];
			dfs(y);
		}
	}

	static void pro() {
		dfs(1); // 루트 노드부터 미리 탐색해서 값을 정해 놓고 뽑아 주기만하면 시간초과를 예방할 수 있다.

		for (int i = 1; i <= N; i++) {
			sb.append(score[i]).append(' ');
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
