package ch09최단경로;

/*
    - 방법 2. 개선된 다익스트라 알고리즘
        * 시간 복잡도: O(E logV), E는 간선의 개수, V는 노드의 개수

        - 기존의 방법 1의 알고리즘과 달리 getSmallestNode()를 작성할 필요가 없다.
        - 최단 거리가 가장 짧은 녿를 선택하는 과정을 우선순위 큐를 이용하는 방식으로 대체
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EnhancedDijkstra {
    public static final int INFINITE = (int) 1e9;

    public static int nodeNum;
    public static int edgeNum;
    public static int start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] distances = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 우선순위 큐 초기화
        pq.offer(new Node(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) { // 큐가 비어있지 않으면 반복
            // 우선순위 큐에서 가지고 온 현재 노드의 정보
            Node currentNode = pq.poll();
            int currentDistance = currentNode.getDistance();
            int currentIndex = currentNode.getIndex();

            if (distances[currentIndex] < currentDistance) { // 현재 노드가 이미 처리되어 있으면 넘어감
                continue;
            }

            for (int i = 0; i < graph.get(currentIndex).size(); i++) { // 현재 노드와 연결된 다른 인접 노드들을 확인
                int cost = distances[currentIndex] + graph.get(currentIndex).get(i).getDistance();

                if (cost < distances[graph.get(currentIndex).get(i).getIndex()]) { // 비용이 더 적다면 갱신
                    distances[graph.get(currentIndex).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(currentIndex).get(i).getIndex(), cost));
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nodeNum = sc.nextInt();
        edgeNum = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= nodeNum; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < edgeNum; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(distances, INFINITE);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= nodeNum; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (distances[i] == INFINITE) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(distances[i]);
            }
        }
    }

}
