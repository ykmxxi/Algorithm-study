package 동적프로그래밍.트리와쿼리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, R, Q; // 정점의 수, 루트의 번호, 쿼리의 수
	static ArrayList<Integer>[] adj;
	static int[] Dy;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		Dy = new int[N + 1];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			adj[x].add(y);
			adj[y].add(x);
		}
	}

	// 1 부터 N 까지의 노드를 각각 루트로 하는 서브트리의 정점의 개수를 Dy 배열에 저장
	static void dfs(int x, int parent) {
		Dy[x] = 1;

		for (int y : adj[x]) {
			if (y == parent) { // 부모 노드이면 넘어간다.
				continue;
			}
			dfs(y, x);
			Dy[x] += Dy[y]; // y는 x의 자식 노드이기 때문에 x를 루트로 하는 트리는 y를 루트로 하는 트리를 포함하고 있다.
		}
	}

	static void pro() throws IOException {
		// Dy 배열 계산: Dy[i]는 i를 루트 노드로 하는 서브트리의 정점의 개수
		dfs(R, -1);

		// Q 줄에 걸쳐 입력 받는다
		for (int i = 1; i <= Q; i++) {
			int Q = Integer.parseInt(br.readLine());
			sb.append(Dy[Q]).append('\n');
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
