package 그래프와탐색.dfs와bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접 행렬 사용
public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, V;
	static int[][] adj;
	static boolean[] visit;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adj = new int[N + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
	}

	static void dfs(int x) {
		// x 를 방문했다.
		visit[x] = true;
		sb.append(x).append(' ');

		// x 에서 갈 수 있는 곳들을 작은 번호부터 모두 방문한다.
		for (int y = 1; y <= N; y++) {
			if (adj[x][y] == 0)
				continue;

			// y 를 이미 갈 수 있다는 사실을 안다면, 굳이 갈 필요 없다.
			if (visit[y])
				continue;

			// y에서 갈 수 있는 곳들도 확인 해보자
			dfs(y);
		}
	}

	// start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();

		// start는 방문 가능한 점이므로 que에 넣어준다.
		que.add(start);
		visit[start] = true;  // start를 갈 수 있다고 표시하기 (중요!!!)

		while (!que.isEmpty()) {  // 더 확인할 점이 없다면 정지
			int x = que.poll();

			sb.append(x).append(' ');
			for (int y = 1; y <= N; y++) {
				if (adj[x][y] == 0)
					continue;
				if (visit[y])
					continue;  // x 에서 y 를 갈 수는 있지만, 이미 탐색한 점이면 무시

				// y를 갈 수 있으니까 que에 추가하고, visit 처리 하기!
				que.add(y);
				visit[y] = true;
			}
		}
	}

	static void pro() {
		visit = new boolean[N + 1];
		dfs(V);

		sb.append('\n');
		for (int i = 1; i <= N; i++) {
			visit[i] = false;
		}

		bfs(V);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
