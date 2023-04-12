package level3.가장먼노드;

/* https://school.programmers.co.kr/learn/courses/30/lessons/49189

    N개의 노드가 있는 그래프, 각 노드는 1 ~ N번
    1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하는 문제 (최단경로로 이동했을 때 간선의 개수가 가장 많은 노드)
        -> 최소 거리 구하기 BFS를 이용해 dist 배열에 거리를 채워나가기
    N은 2 이상 20,000 이하
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

	static int max = 0;
	static ArrayList<Integer>[] adj;
	static int[] dist, visit;

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();

		q.add(1);
		visit[1] = 1;
		dist[1] = 0;

		while (!q.isEmpty()) {
			int x = q.poll();

			for (int y : adj[x]) {
				if (visit[y] == 1) {
					continue;
				}
				dist[y] = dist[x] + 1;
				visit[y] = 1;
				q.add(y);

				max = Math.max(max, dist[y]);

			}
		}

	}

	public int solution(int n, int[][] edge) {
		int answer = 0;

		dist = new int[20001];
		visit = new int[20001];

		adj = new ArrayList[20001];
		for (int i = 0; i <= 20000; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int[] info : edge) {
			int x = info[0];
			int y = info[1];
			adj[x].add(y);
			adj[y].add(x);
		}

		bfs();

		for (int i = 0; i < 20000; i++) {
			if (dist[i] == max) {
				answer++;
			}
		}

		return answer;
	}
}
