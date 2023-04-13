package 동적프로그래밍.트리와쿼리;

/*
	https://www.acmicpc.net/problem/15681

	간선에 가중치와 방향성이 없는 임의의 rooted tree가 주어짐
	정점 U를 루트로 하는 서브트리에 속한 정점의 수를 출력하는 문제
 */

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, R, Q; // 정점의 수, 루트의 번호, 쿼리의 수
	static ArrayList<Integer>[] adj;
	static int[] Dy, visit; // Dy[i] = i를 루트로 하는 트리의 정점 개수

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			adj[x].add(y);
			adj[y].add(x);
		}

	}

	static void dfs(int x) {
		Dy[x] = 1; // 자기 자신을 포함
		visit[x] = 1; // 방문 처리

		for (int child : adj[x]) {
			if (visit[child] == 1) { // 이미 방문했으면(부모 노드라면) 생략
				continue;
			}

			dfs(child);
			Dy[x] += Dy[child]; // x를 root로 하는 트리는 자식을 root로 하는 모든 서브트리의 정점 개수를 합친것과 같음
		}
	}

	static void pro() throws IOException {
		Dy = new int[N + 1];
		visit = new int[N + 1];

		// 초기값인 leaf node 먼저 시작하기 위해 DFS
		dfs(R);

		for (int i = 1; i <= Q; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(Dy[q]).append('\n');
		}

		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
