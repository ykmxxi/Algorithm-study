package 위상정렬.장난감조립;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static int[] indeg;
	static int[][] cnt;
	static ArrayList<Info>[] adj;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		indeg = new int[N + 1];
		cnt = new int[N + 1][N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			adj[x].add(new Info(y, k));
			indeg[y]++;
		}
	}

	static void pro() {
		Deque<Integer> queue = new LinkedList<>();
		// 기본 부품 찾기
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				queue.add(i);
				cnt[i][i] = 1;
			}
		}

		// 먼저 만들 수 있는 제품들부터 차례대로 만들어서 필요 기본 부품 개수 계산하기
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (Info info : adj[x]) {
				int y = info.y, k = info.k;
				indeg[y]--;

				// 제품 y에 제품 x 가 k 개 필요하므로 기본 부품 개수에 k 를 곱해서 누적시켜 준다.
				for (int i = 1; i <= N; i++) {
					cnt[y][i] += cnt[x][i] * k;
				}

				if (indeg[y] == 0) {
					queue.add(y);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (cnt[N][i] != 0) {
				sb.append(i).append(' ').append(cnt[N][i]).append('\n');
			}
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static class Info {
		int y, k;

		public Info(int y, int k) {
			this.y = y;
			this.k = k;
		}
	}
}
