package 트리.나무탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, sum; // sum: 모든 리프 노드들의 깊이의 합
	static ArrayList<Integer>[] adj;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			adj[x].add(y);
			adj[y].add(x);
		}
	}

	static void dfs(int x, int prev, int depth) {
		if (x != -1 && adj[x].size() == 1) { // 루트 노드를 제외하고, 노드와 연결된 정점이 1개 라면 리프 노드
			sum += depth;
		}

		for (int y : adj[x]) {
			if (y == prev) {
				continue;
			}
			dfs(y, x, depth + 1);
		}
	}

	static void pro() {
		dfs(1, -1, 0);

		// TODO: 리프 노드들의 루트 노드 까지의 거리의 합이 짝수: No, 홀수: Yes
		if (sum % 2 == 0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
