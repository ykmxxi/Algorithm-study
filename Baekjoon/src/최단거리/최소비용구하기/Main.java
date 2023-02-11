package 최단거리.최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, start, end; // 정점 V, 간선 E, 출발, 도착
	static int[] dist;
	static ArrayList<Edge>[] edges;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dist = new int[N + 1];
		edges = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edges[from].add(new Edge(to, weight));
		}

		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
	}

	static void dijkstra(int start) {
		// 모든 정점까지에 대한 거리를 무한대로 초기화 해주기.
		// 문제의 정답으로 가능한 거리의 최댓값보다 큰 값임을 보장해야 한다.
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		// 최소 힙 생성
		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

		// 시작점에 대한 정보(Information)을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.
		pq.add(new Info(start, 0));
		dist[start] = 0;

		// 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
		while (!pq.isEmpty()) {
			Info info = pq.poll();

			// 꺼낸 정보가 최신 정보랑 다르면, 의미없이 낡은 정보이므로 폐기한다.
			if (dist[info.idx] < info.dist)
				continue;

			// 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
			for (Edge e : edges[info.idx]) {
				// e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신하고 PQ에 기록해준다.
				if (dist[info.idx] + e.weight >= dist[e.to])
					continue;

				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}

	static void pro() {
		dijkstra(start);
		System.out.print(dist[end]);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static class Edge {
		public int to, weight; // 도착 점, 가중치: 간선의 정보

		public Edge(int _to, int _weight) {
			this.to = _to;
			this.weight = _weight;
		}
	}

	static class Info {
		public int idx, dist; // 도착 점, 갱신된 가중치: 여러 간선을 비교해 최적의 가중치 정보 저장

		public Info() {
		}

		public Info(int _idx, int _dist) {
			this.idx = _idx;
			this.dist = _dist;
		}
	}
}
