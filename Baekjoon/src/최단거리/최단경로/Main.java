package 최단거리.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int V, E, K;
	static ArrayList<Edge>[] edges;
	static int[] dist;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[V + 1];

		K = Integer.parseInt(br.readLine());
		edges = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, weight));
		}
	}

	static void dijkstra(int start) {
		for (int i = 1; i <= V; i++) {
			if (i == start) {
				dist[i] = 0;
			} else {
				dist[i] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
		pq.add(new Info(start, 0));

		while (!pq.isEmpty()) {
			Info info = pq.poll();

			if (dist[info.idx] < info.dist) {
				continue;
			}

			for (Edge e : edges[info.idx]) {
				if (dist[info.idx] + e.weight >= dist[e.to]) {
					continue;
				}

				// e.to 까지 갈 수 있는 더 짧은 거리를 찾았으면, 이에 대한 정보를 갱신하고 PQ에 기록
				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}

	static void pro() {
		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF").append('\n');
			} else {
				sb.append(dist[i]).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static class Edge { // 간선
		public int to, weight; // 도착점, 가중치

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static class Info { // 최단 거리 정보
		public int idx, dist; // 도착점, 거리

		public Info(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}

}
