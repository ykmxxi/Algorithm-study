package ch09최단경로;

/*
    - 방법 1. 간단한 다익스트라 알고리즘
        * 시간 복잡도: O(V^2), V는 노드의 개수
            - O(V)번에 걸쳐 최단 거리가 가장 짧은 노드를 매번 선형 탐색, 현재 노드와 연결된 노드를 매번 확인

        1) 각 노드에 대한 최단 거리를 담는 1차원 리스트를 선언
        2) 단계마다 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택하기 위해
            매 단계마다 1차원 리스트의 모든 원소를 확인(순차 탐색)한다.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    public static final int INFINITE = (int) 1e9;

    public static int nodeNumbers; // 노드의 개수, 노드의 개수는 최대 100,000개
    public static int edgeNumbers; // 간선의 개수
    public static int start; // 시작 노드 번호
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 가중치 방향 그래프
    public static boolean[] visited = new boolean[100001]; // 방문한 적이 있는지 체크하는 목적의 배열
    public static int[] d = new int[100001]; // 최단 거리 테이블

    /**
     * 방문하지 않은 노드 중 가장 최단 거리를 갖는 노드의 번호(인덱스)를 반환
     *
     * @return 최단 거리 노드의 번호(인덱스)
     */
    public static int getSmallestNode() {
        int min_value = INFINITE; // 초기화
        int index = 0; // 최단 거리 노드의 번호(인덱스)

        for (int i = 1; i <= nodeNumbers; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        d[start] = 0;
        visited[start] = true;
        for (int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (int i = 0; i < nodeNumbers - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드를 확인
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nodeNumbers = sc.nextInt();
        edgeNumbers = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= nodeNumbers; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < edgeNumbers; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INFINITE);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= nodeNumbers; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INFINITE) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }

    }

}
