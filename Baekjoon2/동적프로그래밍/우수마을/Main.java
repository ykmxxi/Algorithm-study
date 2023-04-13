package 동적프로그래밍.우수마을;

/*
	https://www.acmicpc.net/problem/1949

	N개의 마을로 이루어진 나라, 1 부터 N번 마을
	이 나라는 트리구조, N - 1개의 간선, 각 간선은 방향성이 없음 (양방향), 모든 마을이 연결되어 있음
	두 마을 사이에 직접 잇는 간선이 있을 때 인접해 있다고 한다
	N개의 마을 중 몇 개의 마을을 우수 마을로, 조건은 다음과 같음
	1. 마을 주민 수의 총 합을 최대로 해야 함
	2. 마을 사이의 충돌 방지를 위해, 인접해 있을 때 두 마을을 모두 우수 마을로 선정 X, 즉, 우수 마을은 인접해 있을 수 없음
	3. 우수 마을로 선정되지 못한 마을은 적어도 하나의 우수 마을과는 인접해 있어야 함
 */

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N; // 1만 이하의 자연수, 마을 개수
	static int[] A, visit; // 각 마을의 인구 (1 ~ N)
	static ArrayList<Integer>[] adj;
	static int[][] Dy;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		A = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

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
		Dy[x][0] = 0;
		Dy[x][1] = A[x];

		visit[x] = 1;

		for (int y : adj[x]) {
			if (visit[y] == 1) {
				continue;
			}

			dfs(y);

			// Dy[x][0] += 모든 자식노드에 대해 Max(Dy[자식노드][0], Dy[자식노드][1])
			Dy[x][0] += Math.max(Dy[y][0], Dy[y][1]);
			// Dy[x][1] += A[x] + 모든 자식노드에 대해 Dy[자식노드][0]
			Dy[x][1] += Dy[y][0];
		}
	}

	static void pro() {
		visit = new int[N + 1];
		Dy = new int[N + 1][2];

		// 진짜 문제: 인접하지 않은 마을들을 골라서 주민 수의 총합을 최대화
		// 가짜 문제: Dy[i][0], i를 root로 하는 서브트리에서 root를 선택하지 않고 가능한 최대 주민 수
		// Dy[i][1], i를 root로 하는 서브트리에서 root를 선택하고 가능한 최대 주민 수
		// Max(Dy[1][0], Dy[1][1]): 1을 root로 하는 트리로 바꾼 후 생각
		// rooted tree로 풀기 때문에 DFS로 leaf node를 초기값으로 설정

		dfs(1);

		System.out.println(Math.max(Dy[1][0], Dy[1][1]));
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
